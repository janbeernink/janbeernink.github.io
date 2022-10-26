<#include "header.ftl">

<div class="post">
	<h1>${content.title}</h1>
	<div class="byline"><span class="posted">${content.date?string("dd MMMM yyyy")}</span> - <span class="author">${content.author}</span></div>

	${content.body}

	<div class="tags">
		Tagged:
		<#list content.tags as tag>
			<a class="tag" href="/tags/${tag}.html">${tag}</a>
		</#list>
	</div>
</div>

<#include "footer.ftl">
