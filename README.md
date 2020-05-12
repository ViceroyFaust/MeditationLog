# MeditationLog
## Brief
I decided to make this program in order to practice basic I/O in Java, while exploring an interest of mine. The idea came to me, as I use an app on my phone to record my meditations and see statistics about them. Once my smartphone breaks, I was planning on simplifying my life by getting a feature phone. That would obviously remove my ability to see those statistics. So, why not kill two birds with one stone? And so I decided to make a small application practicing I/O and maybe even being something functional in the future. Who knows, I might even come back to this and make it better, or remake it in a different language!

## Functions
The MeditationLog has 4 functions. Add, Modify, Remove, and Print Statistics. 

### Add Log
When a user selects to Add a log, they will be asked to provide a valid ISO-8601 (YYYY-MM-DD) date, and a valid length of meditation (HH:MM:SS). Afterwards, the program writes this data to a CSV, with the length being converted into minutes for ease-of-use.

### Modify
When a user selects to Modify a log, they will be asked which date they would like to modify. Once the user enters a valid ISO-8601 (YYYY-MM-DD) date, the program will print out all meditations within that date. The user will then select the date they would like to modify, and may change the meditation length.

This option might seem as though it is not very useful, and you'd probably be right. I planned to implement this feature in order to practice my I/O, but users are welcome to use this as a way to fix incorrect data entry.

### Remove
When a user selects to Remove a log, they will be asked whcih date they would like to remove. Once the user enters a valid ISO-8601 (YYYY-MM-DD) date, the program will print out all meditationg within that date. The user will then be prompted to select which of the logs they would like to delete

### Print Statistics
When a user selects to Print Statistics, the application will go parse through the entire log sheet. The application will determine the latest meditation streak and the longest the user had before, and it will aggregate all of the meditation lengths in order to compile daily, weekly, and monthly averages.
