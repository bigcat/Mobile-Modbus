Mobile Modbus
=============

-------------------

Mobile Modbus is an Android Modbus polling client using modern android UI design guidelines and design patterns such as the Action bar for navigation, a slide-in menu for settings, and appropriately scaled data-display for the device you are working on (i.e. list views on a phone, and a grid on a tablet).

More info to come as this project develops.  Until then feel free to follow along with my [blog](http://www.bencatlin.com) for information, or follow me on [twitter](http://www.twitter.com/bigcat2k).


### Contributing / Reporting Issues
-----------

Eventually I'll put some basic stuff here to know how to contribute more easily - but basically for now, fork the project on github, and submit a pull request and I'll evaluate it and add it if it is in line with what we are after for the goals of the project.

If you see anything wrong with it in any way, just use github to file an issue ticket (please don't comment on my blog about it).


### Building
--------------

This project relies on three libraries:

*  [Modbus4J](http://sourceforge.net/projects/modbus4j/) - a Java Modbus library that is pretty extensible and full-featured with some nice batching functions that we (are going to) make use of.  At some point in the not too distant future, I will push a git-ified version of the original library in CVS on source forge to my github account.
*  [ActionBarSherlock](https://github.com/JakeWharton/ActionBarSherlock) - this is a library that gives us the action bar design pattern that is basically free in 3.0+, but in 2.x versions of android.
*  [SlidingMenu](https://github.com/jfeinstein10/SlidingMenu) - a library that makes it easy to generate a slide-in menu.  We (will) use this for sliding in the connection/slave/server device settings as well as the register settings from the left on demand.  This allows the most screen real-estate for displaying the information that is important the most often - which is the register data.  Please review the section in the readme file on modifying for use with ActionbarSherlock.


Once you have these libraries downloaded - add the two android-specific libraries to your eclipse workspace by selecting new project from file - and then importing the 'library' folder from within those projects.

Then, once they are imported, add them as libraries to the Properties - Android section of the main Mobile Modbus project.

Next import the Modbus4J project as a new eclipse project - right now I'm just checking the whole damned thing out from CVS on sourceforge.   And, then go to Properties - Java Build Path, and click the "Projects" tab at the top.  Now click "Add" and select the modbus4j project from your current eclipse workspace.

This should get you all the libraries you need.
  

#### License

------------
This project is GPL 3.0 because Modbus4J is.


--------------
###### Last edited by [Ben Catlin](mailto://ben@bencatlin.com) on December 29, 2012