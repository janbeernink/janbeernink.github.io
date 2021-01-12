---
title: Re-implementing EJB in CDI
layout: post
tags: 
 - OmniServices
 - CDI
 - EJB
 - Java EE
 - Jakarta EE
 - Stateless session beans
---

The overall goal of CDI is to be the core component model within the Java EE/Jakarta EE ecosystem. It replaced all the various component models that existed within the various Java EE/Jakarta EE specifications with a new, global component model. One of the component models it aims to replace is EJB. However, EJB has a few features that CDI lacks. The most notable are stateless session beans.

Stateless beans are Java objects that have a few very specific properties. First of all, by default, any call to a stateless session bean will start a new JTA transaction if one is not already active. The `@Transactional` annotation allows any CDI bean to have similar transaction support. 

Another big feature is that stateless session beans have a limited number of available instances, which are maintained in a pool. When injecting a reference to a stateless session bean, a proxy is injected instead. As soon as any call is made to that stateless session bean, an instance is exclusively reserved from the pool for the current thread. Once the call completes, the instance is released back into the pool for another thread to use.

The use of a pool of instances has a few benefits. If the stateless session bean has an injected dependency that uses up some finite resource that is expensive to create, for example, an open database connection, it would be preferable to limit the number of active instances and to keep these instances around for re-use. 

To implement such pooling of instances in CDI, it might be helpful to first break the idea of an instance pool in terms of CDI features. A pool of instances could really be described as a pool of scopes, with a scope instance for each instance of our pooled bean. Each scope has a single, exclusive bean instance associated with it. As the beans are scoped, CDI will already inject a proxy automatically for any pooled instance. Then we would need to lock an instance from our pool of scopes and activate this for the current thread and release it once the current call ends.

The most logical way to do this in CDI would be to use an interceptor to lock, activate and release a scope from the pool of scopes would be to use an interceptor. As interceptors can intercept any method call to a bean, this seems to be the ideal way to lock and release a scope. However, there is a problem. Interceptors instances are bound to a single bean instance. This means that we already need to have an active scope for our interceptor to be able to intercept the call, but we can't have an active scope yet as that's what we're trying to use the interceptor for in the first place.