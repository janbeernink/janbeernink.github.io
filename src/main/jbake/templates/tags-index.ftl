<#include "header.ftl">

    <h1>Tags</h1>
    <div id="tags">
        <ul>
            <#list tags as tag>
              <li><a href="${content.rootpath}/${tag.uri}">${tag.name}</a></li>
            </#list>
        </ul>
    </div>

<#include "footer.ftl">