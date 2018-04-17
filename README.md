# CourseApp
This application is to simulate a Course Registration System. This is my first attempt at implementing an application with a GUI. 
Because I have little experience with these techniques, I poorly designed the UI interactions. I ran into a lot of ConcurrentModificationErrors
while trying to loop through Student's List of Courses while in the UI. I learned a lot about actionListeners and their lack of fireEvent order.
For example, the order which ActionListener's run is unreliable and unpredictable on a button click.
