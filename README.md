# Music Manager Exercise
The goal of the exercise is to make a music manager application.  A music manager application allows you to browse through a music library, add new entries and delete them (so the usual Create, Update and Delete stuffs (CRUD)).

All music data should be stored server side in a database.  The client should be a web client.  Communication between clients and server should go over REST.

On the server side we expect the application to be deployed in a Tomcat server.  The client should always communicate to one dedicated service interface (MusicManagerService).  The MusicManagerService implementation is a POJO which is using Spring to interact with the database.

<b>How should the GUI look?</b>

<img src="https://github.com/cminhho/Music-Manager-Exercise/blob/master/screenshots/home.png" width="500">

The GUI can be very basic: a table which lists all music files.  There should be an action bar with 'Add’ (which leads to ‘Add Song’ page mentioned below), ‘Delete’ buttons and a Search box.  

<img src="https://github.com/cminhho/Music-Manager-Exercise/blob/master/screenshots/add_songs.png" width="500">

We also need to support ‘Play’ and ‘Edit’ modes for each song, as followings:

<img src="https://github.com/cminhho/Music-Manager-Exercise/blob/master/screenshots/song_details.png" width="500">
<img src="https://github.com/cminhho/Music-Manager-Exercise/blob/master/screenshots/update_song.png" width="500">


## Technology requirements
### Server
+ Tomcat 7.0.56 (Download link)
+ Eclipse IDE Luna Service Release 1 v4.4.1(Download link)
+ Spring 4.1.1 (No download required)
+ JDK 1.7 (Download link)
+ <b>Nice to have:</b>
  + Spring Security (Login)
  + Notifications to the clients

### Client
+ Javascript
+ AngularJS (MVC)
+ Twitter Bootstrap
+ HTML5/CSS3
+ JSON
+ <b>Nice to have:</b>
  + Unit-testing (Jasmine, Karma)
  + Localization (L10n) and Internalization (i18n)
  + Multi-browser support (Firefox, IE, Safari, Chrome…) => just an improvement
