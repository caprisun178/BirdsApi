<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Bird</title>
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
        form {
            border: 1px solid #333;
            background-color: lightgray;
            padding: 20px;
            border-radius: 8px;
            width: 400px;
            display: flex;
            flex-direction: column;
        }
        input, textarea {
            margin: 8px 0;
            padding: 5px;
            font-family: inherit;
        }
        img {
            margin-top: 10px;
            width: 100%;
            border-radius: 8px;
        }
    </style>
</head>
<body>
<header>
    <h1>Edit Bird</h1>
    <nav>
        <a href="/birds">Home</a> |
        <a href="/birds/about">About</a>
    </nav>
</header>

<main>
    <form action="/birds/update" method="post" enctype="multipart/form-data">
        <input type="hidden" name="birdId" value="${bird.birdId}">

        <label>Name:</label>
        <input type="text" name="name" value="${bird.name}" required>

        <label>Description:</label>
        <textarea name="description" rows="6" maxlength="1000">${bird.description!''}</textarea>

        <label>Habitat:</label>
        <input type="text" name="habitat" value="${bird.habitat!''}">

        <label>Identification Info:</label>
        <input type="text" name="idInfo" value="${bird.idInfo!''}">

        <label>Gender:</label>
        <input type="text" name="gender" value="${bird.gender!''}">

        <label>Last Seen:</label>
        <input type="date" name="lastSeen"
       <#if bird.lastSeen?? && bird.lastSeen?has_content>value="${bird.lastSeen}"</#if>>


        <label>Upload New Image:</label>
        <input type="file" name="image" accept="image/*">

        <#if bird.imageFileName?? && bird.imageFileName?length gt 0>
            <img src="/images/${bird.imageFileName}" alt="${bird.name}">
        </#if>

        <button type="submit">Save Changes</button>
    </form>
</main>
</body>
</html>
