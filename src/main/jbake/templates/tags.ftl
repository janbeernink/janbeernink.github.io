<#include "header.ftl">

    <h1>Tag: ${tag}</h1>

	<div class="tags">
		<ul>
			<#list tag_posts as post>
			<li>${post.date?string("dd MMMM yyyy")} - <a href="${content.rootpath}${post.uri}">${post.title}</a></li>
			</#list>
		</ul>
	</div>
	
<#include "footer.ftl">