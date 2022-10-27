<#include "header.ftl">

    <h1>Recent Posts</h1>

	<#list posts as post>
  		<#if (post.status == "published" && post?index >= (currentPageNumber-1) * config.index_posts_per_page?eval && post?index < currentPageNumber * config.index_posts_per_page?eval)>
			<div class="post-summary">
				<h2><a href="${post.uri?remove_ending("/index.html")}">${post.title}</a></h2>
  				<p>${post.date?string("dd MMMM yyyy")}</p>
  				<p>${post.body?truncate_w(300, '&#8230;')}</p> <#escape x as x?html>
  					${post.body}
  				</#escape>
				<p><a href="${post.uri?remove_ending("/index.html")}">Read more</a></p>
			</div>
  		</#if>
  	</#list>


	<div class="pagination">
		<#if previousFileName??><a href="${previousFileName}">Previous</a></#if>
		<span class="page_number">Page <#if currentPageNumber??>${currentPageNumber}<#else>1</#if><#if nextPage??>of ${nextPage}</#if></span>
		<#if nextFileName??><a href="${nextFileName}">Next</a></#if>
	</div>

<#include "footer.ftl">