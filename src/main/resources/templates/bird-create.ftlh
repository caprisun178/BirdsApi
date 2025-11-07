<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Bird</title>
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
        button {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<header>
    <h1>Add New Bird</h1>
    <nav>
        <a href="/birds">Home</a> |
        <a href="/birds/about">About</a>
    </nav>
</header>

<main>
    <form action="/birds/new" method="post" enctype="multipart/form-data">
        <label>Name:</label>
        <input type="text" name="name" required>

        <label>Description:</label>
        <textarea name="description" rows="6" maxlength="1000">${bird.description!''}</textarea>


        <label>Habitat:</label>
        <input type="text" name="habitat">

        <label>Identification Info:</label>
        <input type="text" name="idInfo">

        <label>Gender:</label>
        <input type="text" name="gender">

        <label>Last Seen:</label>
        <input type="date" name="lastSeen">

        <label>Upload Image:</label>
        <input type="file" name="image" accept="image/*">

        <button type="submit">Save Bird</button>
    </form>
</main>
</body>
</html>
