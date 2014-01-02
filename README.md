Mobile Modbus
=============

-------------------

Mobile Modbus is an Android Modbus polling client using modern android UI design guidelines and design patterns such as the Action bar for navigation, a slide-in menu for settings, and appropriately scaled data-display for the device you are working on (i.e. list views on a phone, and a grid on a tablet).  And as I love all the new hottness, it also is built in Android Studio using the new gradle-based build system, so you will need to download that to work on this project.

More info to come as this project develops.  Until then feel free to follow along with my [blog](http://www.bencatlin.com) for information, or follow me on [twitter](http://www.twitter.com/bigcat2k).


### Contributing / Reporting Issues
-----------

Eventually I'll put some basic stuff here to know how to contribute more easily - but basically for now, fork the project on github, and submit a pull request and I'll evaluate it and add it if it is in line with the goals of the project.

If you see anything wrong with it in any way or just want to add something to the project, file a ticket or submit a pull request.


### Building
--------------

This project relies on two android support libraries, and one 3rd party library:

*  [Modbus4J](http://sourceforge.net/projects/modbus4j/) - a Java Modbus library that is pretty extensible and full-featured with some nice batching functions that we (are going to) make use of.  Just download and copy (or CVS-checkout) it into the top-level "Libraries/Modbus4J" folder (whole project).  There should already be an appropriate build.gradle in that folder, all ready to build the library.


#### License

------------
This project is Apache 2.0, which should be GPL 3.0 compatible, which I/you have to care about because Modbus4J is GPL3.

I'll add the preamble here sometime soon, and get the class header comments all in line as well.

--------------
###### Last edited by [Ben Catlin](mailto://ben@bencatlin.com) on July 29, 2013

[![Analytics](https://ga-beacon.appspot.com/UA-75215-3/Mobile-Modbus/ReadMe)](https://github.com/igrigorik/ga-beacon)
