<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About</title>
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
        main {
            width: 600px;
            background: white;
            padding: 20px;
            border-radius: 10px;
            text-align: center;
        }
        img {
            max-width: 300px;
            border-radius: 10px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<header>
    <h1>About This App</h1>
    <nav>
        <a href="/birds">Home</a> |
        <a href="/birds/new">Add Bird</a>
    </nav>
</header>

<main>
    <img src="/images/default.jpg" alt="Placeholder">
    <p>
        This simple bird-tracking application was designed to help catalog and display birds
        with images, habitats, and other identifying information.
    </p>
    <p>
        It uses Spring Boot, FreeMarker templates, and a connected database for persistent data.
    </p>
</main>
</body>
</html>
