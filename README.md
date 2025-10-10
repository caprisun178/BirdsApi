# BirdsApi
Simple CRUD API for Bird Objects with JPA (Hibernate)

### Version
1.0.0

## Installation
- Get the project
    - clone
        ```
      git clone https://github.com/uncg-csc340/su25-jpa-crud-api.git
        ```
    - OR download zip.
- Open the project in VS Code.
- This project is built to run with jdk 21.
- [Dependencies]([https://github.com/uncg-csc340/su25-jpa-crud-api/blob/3149ec363e4aae4baebe6f755df7d4c2d79c9d2c/pom.xml#L32](https://github.com/csc340-uncg/f25-jpa-crud-api/blob/6b2860c4ad01ca46b6b62852ca966bfadc8dfc6a/pom.xml#L32)) to JPA and Postgres in addition to the usual Spring Web. JPA handles the persistence, Postgresql is the database to be used.
- [`/src/main/resources/application.properties`](https://github.com/csc340-uncg/f25-jpa-crud-api/blob/6b2860c4ad01ca46b6b62852ca966bfadc8dfc6a/src/main/resources/application.properties) This file has the configuration for the PostgreSQL database to use for the API.
  - You MUST have the database up and running before running the project!
    - Login to your neon.tech account.
    - Locate your database project.
    - On the project dashboard, click on "Connect" and select Java.
    - Copy the connection string provided.
    - Paste it as a value for the property `spring.datasource.url`. No quotation marks.
- Build and run the main class. You should see a new table created in the Neon database.

## API Endpoints
Base URL: [`http://localhost:8080/birds`](http://localhost:8080/birds)


1. ### [`/`](http://localhost:8080/birds) (GET)
Gets a list of all Birds in the database.

#### Response - A JSON array of Bird objects.

 ```
[
  {
    "birdId": 2,
    "name": "Ruby-throated Humminhbird",
    "habitat": "Open Woodlands",
    "idInfo": "Tiny, with long wings and bill. Dusky below with a bright red throat, black mask, and green crown.",
    "description": "A flash of green and red, the Ruby-throated Hummingbird is eastern North America’s sole breeding hummingbird. These brilliant, tiny, precision-flying creatures glitter like jewels in the full sun, then vanish with a zip toward the next nectar source. Feeders and flower gardens are great ways to attract these birds, and some people turn their yards into buzzing clouds of hummingbirds each summer. Enjoy them while they’re around; by early fall they’re bound for Central America.",
    "gender": "Male",
    "lastSeen": "2025-09-01"
  },
  {
    "birdId": 4,
    "name": "American Woodcock",
    "habitat": "Forsets",
    "idInfo": "Plump, short-legged and short-necked shorebird with a long, straight bill. Note cinnamon underparts and gray collar.",
    "description": "Superbly camouflaged against the leaf litter, the brown-mottled American Woodcock walks slowly along the forest floor, probing the soil with its long bill in search of earthworms. Unlike its coastal relatives, this plump little shorebird lives in young forests and shrubby old fields across eastern North America.",
    "gender": "Male",
    "lastSeen": "2025-01-15"
  }
]
```

2. ### [`/{birdID}`](http://localhost:8080/birds/1) (GET)
Gets an individual Bird in the system. Each Bird is identified by a numeric `BirdId`

#### Parameters
- Path Variable: `BirdId` &lt;Long &gt; - REQUIRED

#### Response - A single Bird

```
{
  "birdId": 11,
  "name": "American Redstart",
  "habitat": "Forests",
  "idInfo": "A medium-sized warbler with a relatively wide, flat bill and fairly long, expressive tail. Females have yellow patches on the sides, wings and tail.",
  "description": "A lively warbler that hops among tree branches in search of insects, the male American Redstart is coal-black with vivid orange patches on the sides, wings, and tail. True to its Halloween-themed color scheme, the redstart seems to startle its prey out of the foliage by flashing its strikingly patterned tail and wing feathers.",
  "gender": "Female",
  "lastSeen": "2025-10-02"
}
```

3. ### [`/name`](http://localhost:8080/birds/name?key=jo) (GET)
Gets a list of birds with a name that contains the given string.

#### Parameters
- query parameter: `search` &lt; String &gt; - REQUIRED

#### Response - A JSON array of Bird objects.

```
[
  {
    "birdId": 11,
    "name": "American Redstart",
    "habitat": "Forests",
    "idInfo": "A medium-sized warbler with a relatively wide, flat bill and fairly long, expressive tail. Females have yellow patches on the sides, wings and tail.",
    "description": "A lively warbler that hops among tree branches in search of insects, the male American Redstart is coal-black with vivid orange patches on the sides, wings, and tail. True to its Halloween-themed color scheme, the redstart seems to startle its prey out of the foliage by flashing its strikingly patterned tail and wing feathers.",
    "gender": "Female",
    "lastSeen": "2025-10-02"
  },
  {
    "birdId": 12,
    "name": "American Redstart",
    "habitat": "Forests",
    "idInfo": "Adult males are mostly black with bright orange patches",
    "description": "A lively warbler that hops among tree branches in search of insects, the male American Redstart is coal-black with vivid orange patches on the sides, wings, and tail. True to its Halloween-themed color scheme, the redstart seems to startle its prey out of the foliage by flashing its strikingly patterned tail and wing feathers.",
    "gender": "Male",
    "lastSeen": "2025-10-02"
  }
]
```

4. ### [`/habitat/habitat`](http://localhost:8080/birds/major/mathematics) (GET)
Gets a list of birds for a named major.

#### Parameters
- path variable: `habitat` &lt; String &gt; - REQUIRED

#### Response - A JSON array of Bird objects.

```
[
  {
    "birdId": 11,
    "name": "American Redstart",
    "habitat": "Forests",
    "idInfo": "A medium-sized warbler with a relatively wide, flat bill and fairly long, expressive tail. Females have yellow patches on the sides, wings and tail.",
    "description": "A lively warbler that hops among tree branches in search of insects, the male American Redstart is coal-black with vivid orange patches on the sides, wings, and tail. True to its Halloween-themed color scheme, the redstart seems to startle its prey out of the foliage by flashing its strikingly patterned tail and wing feathers.",
    "gender": "Female",
    "lastSeen": "2025-10-02"
  },
  {
    "birdId": 12,
    "name": "American Redstart",
    "habitat": "Forests",
    "idInfo": "Adult males are mostly black with bright orange patches",
    "description": "A lively warbler that hops among tree branches in search of insects, the male American Redstart is coal-black with vivid orange patches on the sides, wings, and tail. True to its Halloween-themed color scheme, the redstart seems to startle its prey out of the foliage by flashing its strikingly patterned tail and wing feathers.",
    "gender": "Male",
    "lastSeen": "2025-10-02"
  }
]
```

5. ### [`/`](http://localhost:8080/birds) (POST)
Create  a new Bird entry

#### Request Body
A Bird object. Note the object does not include an ID as this is autogenerated.
```
{
  "name": "American Redstart",
  "habitat": "Forests",
  "idInfo": "Adult males are mostly black with bright orange patches",
  "description": "A lively warbler that hops among tree branches in search of insects, the male American Redstart is coal-black with vivid orange patches on the sides, wings, and tail. True to its Halloween-themed color scheme, the redstart seems to startle its prey out of the foliage by flashing its strikingly patterned tail and wing feathers.",
  "lastSeen": "2025-10-03",
  "gender": "Male"
}
```
#### Response - The newly created Bird.

```
 {
  "birdId": 12,
  "name": "American Redstart",
  "habitat": "Forests",
  "idInfo": "Adult males are mostly black with bright orange patches",
  "description": "A lively warbler that hops among tree branches in search of insects, the male American Redstart is coal-black with vivid orange patches on the sides, wings, and tail. True to its Halloween-themed color scheme, the redstart seems to startle its prey out of the foliage by flashing its strikingly patterned tail and wing feathers.",
  "gender": "Male",
  "lastSeen": "2025-10-02"
}
```

7. ### [`/{BirdId}`](http://localhost:8080/birds/3) (PUT)
Update an existing Bird.

#### Parameters
- Path Variable: `BirdId` &lt;integer&gt; - REQUIRED

#### Request Body
A Bird object with the updates.
```
 {
    "birdId": 2,
    "name": "Ruby-throated Hummingbird",
    "habitat": "Open Woodlands",
    "idInfo": "Tiny, with long wings and bill. Dusky below with a bright red throat, black mask, and green crown.",
    "description": "A flash of green and red, the Ruby-throated Hummingbird is eastern North America’s sole breeding hummingbird. These brilliant, tiny, precision-flying creatures glitter like jewels in the full sun, then vanish with a zip toward the next nectar source. Feeders and flower gardens are great ways to attract these birds, and some people turn their yards into buzzing clouds of hummingbirds each summer. Enjoy them while they’re around; by early fall they’re bound for Central America.",
    "gender": "Male",
    "lastSeen": "2025-09-01"
  }
```
#### Response - the updated Bird object.
```
{
  "birdId": 2,
  "name": "Ruby-throated Hummingbird",
  "habitat": "Open Woodlands",
  "idInfo": "Tiny, with long wings and bill. Dusky below with a bright red throat, black mask, and green crown.",
  "description": "A flash of green and red, the Ruby-throated Hummingbird is eastern North America’s sole breeding hummingbird. These brilliant, tiny, precision-flying creatures glitter like jewels in the full sun, then vanish with a zip toward the next nectar source. Feeders and flower gardens are great ways to attract these birds, and some people turn their yards into buzzing clouds of hummingbirds each summer. Enjoy them while they’re around; by early fall they’re bound for Central America.",
  "gender": "Male",
  "lastSeen": "2025-08-31"
}
```

8. ### [`/{BirdId}`](http://localhost:8080/birds/3) (DELETE)
Delete an existing Bird.

#### Parameters
- Path Variable: `BirdId` &lt;integer&gt; - REQUIRED

#### Response - the updated list of Birds.
```
[
  {
    "birdId": 9,
    "name": "Eastern Phoebe",
    "habitat": "Open Woodlands",
    "idInfo": "Plump songbird with a large head that often looks peaked. Grayish brown above with a darker head and whitish below",
    "description": " One of our most familiar eastern flycatchers, the Eastern Phoebe’s raspy “phoebe” call is a frequent sound around yards and farms in spring and summer. These brown-and-white songbirds sit upright and wag their tails from prominent, low perches. They typically place their mud-and-grass nests in protected nooks on bridges, barns, and houses, which adds to the species’ familiarity to humans.",
    "gender": "N/A",
    "lastSeen": "2025-01-14"
  },
  {
    "birdId": 11,
    "name": "American Redstart",
    "habitat": "Forests",
    "idInfo": "A medium-sized warbler with a relatively wide, flat bill and fairly long, expressive tail. Females have yellow patches on the sides, wings and tail.",
    "description": "A lively warbler that hops among tree branches in search of insects, the male American Redstart is coal-black with vivid orange patches on the sides, wings, and tail. True to its Halloween-themed color scheme, the redstart seems to startle its prey out of the foliage by flashing its strikingly patterned tail and wing feathers.",
    "gender": "Female",
    "lastSeen": "2025-10-02"
  },
  {
    "birdId": 12,
    "name": "American Redstart",
    "habitat": "Forests",
    "idInfo": "Adult males are mostly black with bright orange patches",
    "description": "A lively warbler that hops among tree branches in search of insects, the male American Redstart is coal-black with vivid orange patches on the sides, wings, and tail. True to its Halloween-themed color scheme, the redstart seems to startle its prey out of the foliage by flashing its strikingly patterned tail and wing feathers.",
    "gender": "Male",
    "lastSeen": "2025-10-02"
  },
  {
    "birdId": 2,
    "name": "Ruby-throated Hummingbird",
    "habitat": "Open Woodlands",
    "idInfo": "Tiny, with long wings and bill. Dusky below with a bright red throat, black mask, and green crown.",
    "description": "A flash of green and red, the Ruby-throated Hummingbird is eastern North America’s sole breeding hummingbird. These brilliant, tiny, precision-flying creatures glitter like jewels in the full sun, then vanish with a zip toward the next nectar source. Feeders and flower gardens are great ways to attract these birds, and some people turn their yards into buzzing clouds of hummingbirds each summer. Enjoy them while they’re around; by early fall they’re bound for Central America.",
    "gender": "Male",
    "lastSeen": "2025-08-31"
  }
]
```

## DEMO LINK
https://uncg-my.sharepoint.com/:v:/g/personal/siparisi_uncg_edu/ES4iMKsuddRIgVewIz9TsUQBU3mYSyxlxQSnDNpbkWlv7w?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&e=GG9WkU