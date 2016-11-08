By Edan Meyer

The program can take a set of lines within a 1 by 1 square and determine 
whether or not there are any lines in between any two given points in an
average of log(n) time.

Note: This was a school project

Growth:
- The average path length, grows at about a rate of log(n) because each
subsequent level of depth can hold two times as many nodes as the previous
- The number of external nodes grows somewhat steadily, almost linearly

Note on test cases and output:
- Rather than one test and OUTPUT.txt file, I have multiple which can be found
in the /samples directory

IMPORTANT NOTES ON IO:
- When typing in input, because the number of points is not given, to stop the
program and also print the number of external nodes and average parth length,
you must hit CTRL+D on (most) UNIX or CTRL+Z on Windows

Some of the more important things about how the code works (Optional Info):
- Most of the BST methods are recursive, using nodes to call their children
- The insert, which serves as the basis for contructing the BSTs works by
recureively reinserting on both children if the lines intersect, on the
leftChild if the inserted line's midpoint is to the left of the other line,
- When a line segment is inserted after an intersection, although it is not
noticable to the user, the segment splits into two different halfs at the
intersection point
and to the right otherwise
- Intersections were checked with simple manipulation of a linear function
- They were then confirmed to be line SEGMENT intersection with the onSegment()
method that checks if a point is on a segment
- I found that the ccw method provided in the PDF did not match the example
tree also depicted in the PDF
- So I made my own ccw, although it really checks if a point is to the left
of a line because I feel like that is more intuative and it is how the visual
tree was represented in the PDF
- The function works in a way similar to raycasting to the left and checking for
intersection with the point in question, if it hits, its to the left, if not, right
