<#if content.type == 'post'>
    <#if content.title??>
        <#assign content_title = content.title>
    <#else>
        <#assign content_title = config.site_name>
    </#if>

    <#if content.noExtensionUri??>
        <#assign content_url = config.site_host + "/" + content.noExtensionUri?remove_ending("/")>
    </#if>
    <meta property="og:title" content="${content_title}"/>
    <meta name="author" content="<#if content.author??>${content.author}<#else>${config.site_author}</#if>"/>
    <meta property="og:locale" content="en_US"/>

    <#if content.body??>
        <#assign content_description = content.body?replace('<[^>]+>','','r')?truncate_w(400)>
        <meta name="description" content="${content_description}"/>
        <meta property="og:description" content="${content_description}"/>
    </#if>

    <#if content_url??>
        <link rel="canonical" href="${content_url}"/>
        <meta property="og:url" content="${content_url}"/>
    </#if>
</#if>
