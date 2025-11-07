<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bird Gallery</title>
    <style>
        body {
            font-family: 'Segoe UI', Arial, Helvetica, sans-serif;
            background-color: #f3f3f3;
            display: flex;
            flex-direction: column;
            align-items: center;
            margin: 0;
            padding: 20px;
        }
        header {
            text-align: center;
            margin-bottom: 20px;
        }
        nav ul {
            list-style: none;
            display: flex;
            gap: 32px;
            padding: 0;
            margin: 0;
        }
        nav a {
            text-decoration: none;
            font-weight: bold;
            color: #333;
        }
        .gallery {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            width: 100%;
        }
        .card {
            width: 280px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            padding: 16px;
            text-align: center;
        }
        .card img {
            width: 100%;
            border-radius: 8px;
        }
        .actions a {
            margin: 0 6px;
            text-decoration: none;
            color: #0074D9;
        }
    </style>
</head>
<body>
<header>
    <h1>Bird Gallery</h1>
    <nav>
        <ul>
            <li><a href="/birds">Home</a></li>
            <li><a href="/birds/new">Add Bird</a></li>
            <li><a href="/birds/about">About</a></li>
        </ul>
    </nav>
</header>

<main>
    <form method="get" action="/birds" style="margin-bottom:20px; display: flex; gap: 10px; flex-wrap: wrap; justify-content: center;">
        <input type="text" name="name" placeholder="Search by name..." value="${searchTerm!}">
        <input type="text" name="gender" placeholder="Search by gender..." value="${gender!}">
        <input type="text" name="habitat" placeholder="Search by habitat..." value="${habitat!}">
        <button type="submit">Search</button>
        <a href="/birds" style="margin-left:10px;">Clear</a>
    </form>


    <#if birdList?has_content>
        <div class="gallery">
        <#list birdList as bird>
            <div class="card">
                <#if bird.imageFileName?? && bird.imageFileName?length gt 0>
                    <img src="/images/${bird.imageFileName}" alt="${bird.name}">
                <#else>
                    <img src="/images/default.jpg" alt="No image available">
                </#if>
                <h3>${bird.name}</h3>
                <p>${bird.habitat!''}</p>
                <div class="actions">
                    <a href="/birds/${bird.birdId}">View</a>|
                    <a href="/birds/update/${bird.birdId}">Edit</a>|
                    <a href="/birds/delete/${bird.birdId}" onclick="return confirm('Delete this bird?');">Delete</a>
                </div>
            </div>
        </#list>
        </div>
    <#else>
        <p>No birds found.</p>
    </#if>
</main>
</body>
</html>
