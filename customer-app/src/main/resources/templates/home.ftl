<#import "/spring.ftl" as spring />
<#assign xhtmlCompliant = true in spring>
<!DOCTYPE html>
<html>
<head>
    <title>${serviceName}</title>
</head>
<body>

<header>
    <a href="${productServiceUrl}">Products</a>
</header>

<h1>${serviceName}</h1>

<ul>
    <li><a href="<@spring.url '/customers' />">Customer Listing</a></li>
    <li><a href="<@spring.url '/admin' />">Customer Admin Page</a></li>
</ul>
</body>
</html>
