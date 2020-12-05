Original App Design Project - README Template
===

# Care-Hub

## Table of Contents
1. [Overview]()
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
 CareHub is a lot more than just focusing on improving university students social emotional and mental well-being.
We’re a community of students, phycologist and therapist



### App Evaluation
[Evaluation of your app across the following attributes]
- 
- **Mobile:** Android mobile application which uses Java, Android Studio, Google Maps, APIs, Health Department APIS, Firebase.
- **Story:** Due to COVID, university students struggle with mental issues such as anxiety and depression on every college campus and had difficulty accessing mental health care and expressing their emotional concerns, prompting calls for a broad response from colleges and society. The purpose of Carehub is to help people who are suffering from depressions, ansxities and loneliness, by connecting them to community of counsellors and theraphists who can give them guidance and help them from taking wrong steps during extreme depression and connect them with people.

- **Market:**No. of College student by Category:
16.9 million undergraduate students
3.0 million graduate students
12.1 million full-time students
7.8 million part-time students
14.7 million students at public institutions
5.2 million students at private institutions
No. of College student by Sex:
11.3 million Female Students 
8.6 million male students
No. of College student by Race / Ethnicity:
10.5 million White
3.6 million Hispanic 
2.6 million Black
1.3 million Asian/Pacific Islander
0.7 million two or more Races
0.1 million American Indian/Alaska Native
1.1 million Non-Resident Alien
TAM
$ 80 Million
(If charged $3.99 / month)

- **Habit:** The user can interact with other people who are having the same problem and share their experiences and connect with them. Based on the mood of the user, the app can recommend tips on improving their health condition by giving them access to useful and interactive articles regarding the depression.User Can find a nearby therapist for counselling. 
- **Scope:**
-Provide android version of the app initially for target users facing depression and loneliness.
**Second Stage:** Develop the IOS and web version of the application that is available for every user from anywhere.

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

*[x] User can sign up and create an account. 
*[x] User can sign in and out.
*[x] User receives daily health-related quotes once loginto their account.
* User can read articles based on the mood they search for such as happiness, sadness, depression.
* User can connect with people who are also suffering from depression.
* User can look up for nearby therphists and health experts to take recommendations.
* ...

**Optional Nice-to-have Stories**

* [fill in your required user stories here]
* ...

### 2. Screen Archetypes

* Log in
* Register- User signs up or Log into their account
   * Upon Download/Reopening of the application, the user is prompted to log in to gain access to their profile information.
   * Once the new user log into their account, they are given information about the carehub and the way to use it.
* Home Screen- User recieves health-related quotes on the homescreen. They can also select the mood from the "mood's" toolbar.
   * Types of moodes: Anxious, Scared, Stressed, Happy, Excited, Overwhelmed, Nervous
   * ...
* Hubs- This page shows the already added friends. It shows the status of the friends whether they are online or Offline.
*Matching: This page allows the user to swipe different users for matching. If they match, the person is added to the friend's list of the user.
My Profile: This page allows the user to edit their profile infromation and update their profile pictures.
### 3. Navigation

**Tab Navigation** (Tab to Screen)

* User is prompted to sinup and create an account.
* Once the user creates the account, they can log in to home screen
* In the homepage, they can navigate between hub page and profile page. 
* In the hub page the user can match with the desired person. 
* In the profile page, the user can change their user name and profile pic.

**Flow Navigation** (Screen to Screen)

* Registration Page
   *Log In Page 
   *HomePage
   *Connect Page
   *


## Wireframes
[Add picture of your hand sketched wireframes in this section]
<img src="https://github.com/snehamsuresh/Care-Hub/blob/main/videowalkthroughcare.gif" width=600>

### [BONUS] Digital Wireframes & Mockups
<img src="https://github.com/snehamsuresh/Care-Hub/blob/main/carehub1.png" width=600>
<img src="https://github.com/snehamsuresh/Care-Hub/blob/main/carehub2.png" width=600>
<img src="https://github.com/snehamsuresh/Care-Hub/blob/main/carehub3.png" width=600>

### [BONUS] Interactive Prototype

## Schema 
[This section will be completed in Unit 9]
### Models
*User: This model class contains information about the friends of the user:
| Property | Type | Description |
| :---         |     :---:      |          ---: |
| ObjectId     | String         | unique id for the user post (default field)|
| Image        | File           | Image that user sees when swipes |
| Status       | Boolean        | Shows whether the swipped user is online or not|
| Bio          | String         | Contains information about the swiped user|
| Location     | String         | Shows the location of the swipped user|

### Networking
-List of network requests by screen
Home Feed Screen
(Read/GET) Query all posts where user is author
let query = PFQuery(className:"Post")
query.whereKey("author", equalTo: currentUser)
query.order(byDescending: "createdAt")
query.findObjectsInBackground { (posts: [PFObject]?, error: Error?) in
   if let error = error { 
      print(error.localizedDescription)
   } else if let posts = posts {
      print("Successfully retrieved \(posts.count) posts.")
  // TODO: Do something with posts...
   }
}
(Create/POST) Create a new like on a post
(Delete) Delete existing like
(Create/POST) Create a new comment on a post
(Delete) Delete existing comment
Create Post Screen
(Create/POST) Create a new post object
Profile Screen
(Read/GET) Query logged in user object
(Update/PUT) Update user profile image
