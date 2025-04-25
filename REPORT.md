# COM1008 - Software Engineering
# Assignment 1 - Report

**Student Name: Tamara Sovcikova**

**Student ID: 6862627**

## 1.1 Proto Personas

### Persona 1

 **Justin Stewart - Data Analyst at a Marketing Agency**

Justin Stewart is a 42-year-old data analyst in Bristol, currently working at a mid-sized marketing agency. With a background in public health research and a degree in Statistics, he transitioned into marketing analytics and now focuses on uncovering trends and building dashboards for campaign strategies. He regularly works with tools like Python, Power BI, and public APIs, and values platforms that are fast, accurate, and easy to integrate. Justin's main goal is to quickly access clean, structured data for trend analysis and reporting. He gets frustrated with slow tools and fragmented data sources that require manual cleaning. Efficiency and reliability are key to his work, as he often faces tight deadlines and needs tools that fit seamlessly into his workflow.

### Persona 2

**Amira Khan - Film Studies Student**

Amira Khan, 22, is a second-year Film and Screen Studies student at the University of Brighton. After completing a degree in English Literature, she transitioned to film studies to explore how directors' unique storytelling techniques shape their films. Her goal is to excel in writing insightful research papers that analyze directors' techniques and storytelling methods. Amira is skilled at critical thinking and film analysis, often comparing directors' styles and identifying patterns. She spends significant time researching films, gathering data on directors, and reading reviews to support her assignments. However, she finds it difficult to gather reliable, structured data from various sources, especially when researching lesser-known films. She needs a tool that allows her to quickly access detailed and accurate film data, saving her time on research so she can focus on analysis and writing. 

## 1.2 Scenario

**Using FlickFinder to Steamline Actor Popularity Analysis**
It's a Tuesday morning, and Justin is getting started with his usual routine at the marketing agency's analytics desk. A new campaign brief has come in from a film distributor client. They want to target the 80s and 90s nostalgia trend by finding out which actors from that era are becoming popular again. Justin's job is to identify these actors and their recent film appearances.

At first, Justin tries to gather the data from various sources, like film databases, spreadsheets, and web searches. However, the process is slow and frustrating. He finds himself spending hours looking for details about each actor's filmography, release dates, genres, directors, and performance metrics over time. When he tracks down a new film, he has to cross-reference everything manually, and the data is often incomplete or outdated. It becomes a huge time sink, and after a while, Justin feels overwhelmed.

After talking to a colleague about his frustration, Justin is recommended FlickFinder. The tool promises to make the process faster and more efficient. Curious, Justin decides to give it a try.

He opens FlickFinder and quickly notices how easy it is to use. He can search for specific actors, directors, or films, and the platform provides structured data on each film, including the title, release year, genre, and director. The search results are neatly organized, and Justin can filter them by year and ratings, which helps him focus only on the relevant films.

With FlickFinder, Justin no longer has to spend hours searching and cross-referencing data. He exports the results into a Python script to track how often an actor appears in films over time. When he sees that one actor has had a noticeable increase in roles from 2019 to 2023, he adds additional performance metrics from other sources and builds a Power BI dashboard for the campaign team.

By lunchtime, Justin has all the data he needs. He has analyzed it, built the report, and is ready to present it to the client. The team is excited about the insights, and Justin feels a sense of relief. FlickFinder didn't just save him hours; it made the whole process easier and more reliable. While the tool didn’t provide every piece of the data he needed, it gave him a solid foundation that allowed him to focus on the more valuable analysis.

## 1.3 User Stories

### User Story 1

**Search for Movies by Criteria**

As a guest user, I want to search for movies based on release year and genre, so I can quickly find movies that interest me without needing to create an account.

### User Story 2

**Watchlist**

As a logged-in user, I want to create a watchlist of movies I want to watch in the future, so I can easily keep track of them and receive notifications when they become available.

### User Story 3

**Movie Discussion Forums**

As a logged-in user, I want to join movie discussion forums, so that I can connect with other fans, share my thoughts, and explore new views on films.

### User Story 4

**Administrator**

As an administrator, I want to be able to assign user roles with specific permissions, so users only access the features they are allowed to and maintain the security and integrity of the app.

### User Story 5

**Moderator**

As a moderator, I want to have a review system for movie submissions, so I can approve or reject movies based on quality and appropriateness before they are published on the platform.

### User Story 6

**Movie Recommendations**

As a logged-in user, I want to receive personalized movie recommendations based on my past searches, ratings, and favorites, so I can discover new films that match my interests.

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
