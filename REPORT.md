# COM1008 - Software Engineering
# Assignment 1 - Report

**Student Name: Tamara Sovcikova**

**Student ID: 6862627**

## 1.1 Proto Personas

### Persona 1

 **Justin Stewart - Data Analyst at a Marketing Agency**

Justin Stewart is a 42-year-old data analyst in Bristol, currently working at a mid-sized marketing agency. With a background in public health research and a degree in Statistics, he transitioned into marketing analytics and now focuses on uncovering trends and building dashboards for campaign strategies. He regularly works with tools like Python, Power BI, and public APIs, and values platforms that are fast, accurate, and easy to integrate. Justin's main goal is to quickly access clean, structured data for trend analysis and reporting. He gets frustrated with slow tools and fragmented data sources that demand manual cleaning, making efficiency his top priority to meet tight deadlines.

### Persona 2

**Amira Khan - Film Studies Student**

Amira Khan, 22, is a second-year Film and Screen Studies student at the University of Brighton. After completing a degree in English Literature, she switched to film studies to better understand how directors use different techniques to shape their films. Outside of her studies, she enjoys creative writing, visiting independent cinemas, and taking part in local film discussion groups, where she often finds new ideas and inspiration. She aims to develop strong research papers that break down directors' storytelling styles, using her critical thinking to spot patterns and connections. Most of her time goes into digging through films, director profiles, and reviews to build strong arguments for her work. However, she finds it difficult to gather reliable, structured data from various sources, especially when researching lesser-known films. She needs a tool that can give her quick access to accurate film data, helping her save time on research so she can focus more on her analysis and writing.

## 1.2 Scenario

**Using FlickFinder to Steamline Actor Popularity Analysis**
It's a Tuesday morning, and Justin is getting started with his usual routine at the marketing agency's analytics desk. A new campaign brief has come in from a film distributor client. They want to target the 80s and 90s nostalgia trend by finding out which actors from that era are becoming popular again. Justin's job is to identify these actors and their recent film appearances.

At first, Justin tries to gather the data from various sources, like film databases, spreadsheets, and web searches. However, the process is slow and frustrating. He spends hours digging through scattered information on actors' filmographies, release dates, genres, directors, and performance stats, often cross-referencing outdated or incomplete data. Over time, the constant searching becomes overwhelming and drains his energy.

After talking to a colleague about his frustration, Justin is recommended FlickFinder. The tool promises to make the process faster and more efficient. Curious, Justin decides to give it a try.

He opens FlickFinder and quickly notices how easy it is to use. He can search for specific actors, directors, or films, and the platform provides structured data on each film, including the title, release year, genre, and director. The search results are neatly organized, and Justin can filter them by year and ratings, which helps him focus only on the relevant films.

With FlickFinder, Justin no longer has to spend hours searching and cross-referencing data. He exports the results into a Python script to track how often an actor appears in films over time. When he sees that one actor has had a noticeable increase in roles from 2019 to 2023, he adds additional performance metrics from other sources and builds a Power BI dashboard for the campaign team.

By lunchtime, Justin has all the data he needs. He has analyzed it, built the report, and is ready to present it to the client. FlickFinder didn't just save him hours; it made the whole process easier and more reliable.

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

Although I had prior experience building REST APIs with Express.js, Javalin's stricter conventions provided a much clearer structure, especially with the separating of models, DAOs, and controllers. The project layout also made debugging and adding new features, like routes, a more consistent and repeatable process.

Efficiency was a constant priority, especially when handling a large dataset. I learned that implementing sensible defaults, such as a LIMIT 50 on queries, helped maintain responsiveness and avoid performance bottlenecks as the dataset grew. In hindsight, tying limits to pagination would have made the API even more scalable for real-world applications. I also focused heavily on input validation, particularly for parameters like limit and votes, rejecting non-integer and negative values. This should improve system stability and strengthen security by preventing injection attacks and malformed requests.

If I were to improve the project, security would be my main focus. I would implement user authentication with something like JSON Web Tokens (JWT) to secure access to specific routes, especially with the introduction of user roles and a login system. Additionally, I'd review database queries for optimization, like adding indexes to frequently filtered columns, to improve efficiency as FlickFinder scales.


### 2.2 Professional Aspects

FlickFinder's use of the Model-View-Controller (MVC) architecture is an excellent choice for maintaining an organized, scalable mobile app. By separating concerns across layers, it makes refactoring and documentation more manageable as the app grows. Coupled with best practices in coding, input validation, and defensive programming, MVC helps reduce redundancy and prevent the creation of ‘spaghetti’ code. This proactive approach to error handling simplifies debugging, ensures smooth scaling, and optimizes performance, leading to a more consistent user experience across devices.

As the app continues to evolve, it will need to adhere to key legal frameworks such as the UK Data Protection Act 2018 and UK GDPR. Introducing features like user accounts and personalized movie recommendations requires clear transparency in data collection, secure data management, and user control over their information. Adopting these measures will not only ensure compliance with standards set by organizations like the BCS, but also demonstrate professionalism. Additionally, FlickFinder’s design should prioritize fairness and avoid bias in future features like recommendations, upholding ethical standards, free from harmful content.

To ensure inclusivity, FlickFinder should also meet WCAG 2.2 standards, improving accessibility for users with disabilities by making content perceivable, operable, understandable, and robust. Features like dark mode and progressive content loading will enhance user experience while reducing energy consumption, benefiting both users and their devices.

Additionally, sustainable coding practices should be a priority for apps with media-heavy content, such as FlickFinder, as they can significantly improve efficiency and reduce environmental impact. This includes optimizing media storage for high-quality movie posters and trailers, as well as reducing server load through data compression or implementing efficient caching strategies, all of which help minimize data usage.


## 3. References

Appleton, J. (2025). Systems modelling [Lecture slides]. University of Surrey.

Newman, A., & Winks, O. (2025). Software's role in sustainability [PowerPoint slides]. Presented as part of the 10th lecture in Computer Science Software Engineering by Appleton, J., University of Surrey.