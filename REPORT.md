# COM1008 - Software Engineering
# Assignment 1 - Report

**Student Name: Tamara Sovcikova**

**Student ID: 6862627**

## 1.1 Proto Personas

### Persona 1

 **Justin Stewart - Data Analyst at a Marketing Agency**

Justin Stewart, aged 42, is a data analyst at a mid-sized marketing agency in Bristol. He has a degree in Statistics from the University of Exeter and worked in public health research before joining the agency, where he’s been for the past six years. He is currently building a dashboard to analyse actor popularity over time and chose FlickFinder as a fast way to search and cross-reference films by specific actors and directors.

### Persona 2

**Amira Khan - Film Studies Student**

Amira Khan, aged 22, is a film studies student at the University of Brighton, where she is in her second year of a Film and Screen Studies degree. She has always been passionate about movies, particularly in understanding how directors' unique styles influence their work. After completing a degree in English literature, she shifted her focus to film to deepen her knowledge of cinema. Amira uses FlickFinder to quickly search for movies by her favourite directors and cross-reference ratings and reviews, which helps her gather reliable data for research papers.

## 1.2 Scenario

**Using FlickFinder to Track Actor Popularity Trends**

Justin Stewart, a 42-year-old data analyst at a mid-sized marketing agency in Bristol, usually works on film-related projects, helping the agency make data-driven marketing decisions. His current task is to build an interactive dashboard that shows how actor popularity changes over time by spotting trends, linking film appearances to box office success, and highlighting spikes in interest around certain releases or collaborations.

To do this, Justin needs structured data on actors’ filmographies, release dates, genres, directors, and performance metrics over time. At first, he tries using various sources: film databases, spreadsheets, and manual web searches. But the process is slow and frustrating. He ends up spending hours cross-referencing information just to track how an actor’s popularity shifts over time.

After expressing his frustration to a colleague, he’s recommended FlickFinder, a tool that makes it easy to search and cross-reference films by actor or director. With it, Justin can quickly search for an actor’s name and get a complete, filterable list of their films, along with release years and directors. This saves him a lot of time and lets him bring clean, organised data straight into his dashboard.

With FlickFinder streamlining his workflow, Justin can focus on analysis and deliver insights that help the agency spot trends and refine their marketing strategies.

## 1.3 User Stories

### User Story 1

**Sort movies by rating**

As a user, I want to sort movies by rating so I can see the highest-rated ones at the top of my search results.

### User Story 2

**Save favourite movies to personal list**

As a logged-in user, I want to be able to save my favourite movies to a personal list so I can easily come back to them later and keep track of what I want to watch.

### User Story 3

**Look up information about a specific actor**

As a user, I want to look up information about a specific actor so I can find out more about their career and the movies they've been in.

### User Story 4

**Search for movies of a specific actor**

As a user, I want to search for all the movies a particular actor has been in so I can explore their full filmography.

### User Story 5

**Limit search results**

As a user, I want to be able to limit the number of results when searching for movies or people so I can focus on a smaller, more manageable set of options.

### User Story 6

**[]**

[]

## 2 Critical Analysis and Reflection

### 2.1 Reflection

This project was a great opportunity to reinforce key aspects of back-end development, particularly within the Java ecosystem. Although I had experience with REST APIs using Express.js, Javalin’s stricter conventions brought a refreshing sense of structure. The project layout clarified how layers like models, DAOs, and controllers interact, which made debugging easier and made adding new features, like routes, a consistent, replicable process.

Working with a large dataset made efficiency a priority. I paid close attention to implementing sensible defaults, like the LIMIT 50, to avoid performance bottlenecks. I focused on input validation, particularly for parameters like limit and votes, rejecting non-integer and negative values to ensure the system remained secure and efficient. Given my past challenges with SQL in relational databases, I found it a relief that most queries were straightforward, relying primarily on simple SELECT, FROM, and WHERE clauses, with only occasional joins.

If I were to improve the project, security would be my main focus. I would explore user authentication and implement something like JSON Web Tokens (JWT) to secure access to specific routes, especially with the introduction of user roles and a login system as FlickFinder grows.


### 2.2 Professional Aspects

The Model-View-Controller (MVC) architecture in FlickFinder is key to organizing the app’s structure. By separating concerns across layers, it supports scalability, refactoring, and documentation, essential as the app develops for mobile. This approach, along with consistent naming conventions, input validation, and good coding practices, ensures maintainability, reduces duplicate logic, and prevents 'spaghetti code,' making it easier to debug, extend, and scale. As the app evolves, these practices also help optimize performance, add new features, and maintain a consistent user experience across devices.

Looking ahead, FlickFinder must adhere to the UK Data Protection Act 2018 and UK GDPR. As features like user accounts and personalized recommendations are introduced, maintaining transparency in data collection and usage will be vital. The system should give users control over their data while ensuring its secure storage and use. Additionally, ethical design practices must ensure that recommendations remain fair, unbiased, and free from harmful content

In terms of accessibility, meeting WCAG 2.2 standards will ensure that the application is usable by all users, including those with disabilities. Adding features such as dark mode and progressive content loading would not only improve the user experience but also reduce energy consumption, benefiting users and their devices.

Lastly, making sustainable deployment choices, such as transitioning to a cloud-based infrastructure could also be considered. Deploying using energy-efficient cloud regions and carbon-aware scheduling would reduce the FlickFinder’s overall carbon footprint, contributing to a more sustainable future.


## 3. References

[use a know referencing style, for example APA, Harvard, etc.]
include the presentation slides + the brief and such
