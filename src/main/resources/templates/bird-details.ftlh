<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${bird.name}</title>
    <style>
        body {
            font-family: 'Segoe UI', Arial, Helvetica, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            background-color: #f3f3f3;
            margin: 0;
            padding: 20px;
        }
        img {
            border-radius: 8px;
            max-width: 600px;
            width: 100%;
            margin-bottom: 20px;
        }
        nav ul {
            list-style: none;
            display: flex;
            gap: 32px;
            padding: 0;
        }
        nav a {
            text-decoration: none;
            font-weight: bold;
            color: #333;
        }
        .details {
            background-color: white;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            width: 600px;
        }
        .details p {
            margin: 8px 0;
        }
    </style>
</head>
<body>
<header>
    <h1>${bird.name}</h1>
    <nav>
        <ul>
            <li><a href="/birds">Home</a></li>
            <li><a href="/birds/new">Add Bird</a></li>
            <li><a href="/birds/about">About</a></li>
        </ul>
    </nav>
</header>

<#if bird.imageFileName?? && bird.imageFileName?length gt 0>
    <img src="/images/${bird.imageFileName}" alt="${bird.name}">
<#else>
    <img src="/images/default.jpg" alt="No image available">
</#if>

<div class="details">
    <p><strong>Description:</strong> ${bird.description!''}</p>
    <p><strong>Habitat:</strong> ${bird.habitat!''}</p>
    <p><strong>Gender:</strong> ${bird.gender!''}</p>
    <p><strong>Identification Info:</strong> ${bird.idInfo!''}</p>
   <p><strong>Last Seen:</strong>
  <#if bird.lastSeen?? && bird.lastSeen?has_content>
      ${bird.lastSeen}
  <#else>
      Unknown
  </#if>
</p>
</div>
</body>
</html>
