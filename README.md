# Duke Application 

_Duke_ is an application for users to store different tasks types. It's named after the Java mascot _Duke_. 
Given below are instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)
1. Set up the correct JDK version, as follows:
   1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
1. Import the project into Intellij as follows:
   1. Click `Open or Import`.
   1. Select the project directory, and click `OK`
   1. If there are any further prompts, accept the defaults.
1. After the importing is complete, locate the `src/main/java/Duke.java` file, right-click it, and choose `Run Duke.main()`. If the setup is correct, you should see something like the below:
   ```
   Hello from
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
   
   Hello! I'm Duke
   What can I do for you ?
   ```
## Using the application

1. This application is a CLI application. Users can interact with the application by typing in commands into the prompt. 
The features and commands for the application are shown in section 2 below.

1. Features and commands: 
    1. View all the tasks stored in the task list: `list`
    1. Add a Todo task into the task list: `todo <task name>` eg. `todo study CS2113T`
    1. Add a Deadline task into the task list: `deadline <task name> /by <time>` eg. `deadline assignment 1 /by tuesday 2pm`
    1. Add an Event task into the task list: `event <task name> /at <time>` eg. `event team project meeting /at 1 Oct 2020, 5pm`
    1. Mark a task as done: `done <task number>` eg. `done 1`
    1. Delete a task from the task list: `delete <task number>` eg. `delete 1`
    1. Search relevant tasks by using a keyword: `find <keyword>` eg. `find study`
    1. Exit the program: `bye`
    
1. Notes:
    1. All command keywords (`list`, `todo`, `deadline`, `event`, `done`, `delete`, `find`, `bye`) are case-insensitive.
    1. `done` and `delete` command can only take in one task number at a time.
   