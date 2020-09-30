# User Guide
_Duke_ is a desktop application for users to store different tasks types through a command line interface.

##Quick Start
1. Ensure that you have Java 11 or above installed on your computer.
1. Download the latest version of Duke.jar from https://github.com/lhydl/ip/releases
1. Save the jar file to a folder of your choice.
1. Open a command prompt and navigate to the folder that contains the jar file. Command: `cd <directory/filename>`
1. Type in the `java -jar Duke.jar` command and press enter to run the program.
1. Refer to the Features and Usage section for more details on the application's available commands.

## Features 
### Notes about the command format:
1. Items in <> are the parameters to be supplied by the user.
   e.g. in `todo <task name>`, task name is a parameter which can be used as `todo study CS2113T`.

### Features and Commands
1. View all the tasks stored in the task list: `list`
1. Add a Todo task into the task list: `todo <task name>` 
1. Add a Deadline task into the task list: `deadline <task name> /by <time>` 
1. Add an Event task into the task list: `event <task name> /at <time>` 
1. Mark a task as done: `done <task number>` 
1. Delete a task from the task list: `delete <task number>` 
1. Search relevant tasks by using a keyword: `find <keyword>` 
1. Exit the program: `bye`
    
## Usage

### Example of usage: 

1. `list`
1. `todo study CS2113T`
1. `deadline assignment 1 /by tuesday 2pm`
1. `event team project meeting /at 1 Oct 2020, 5pm`
1. `done 3`
1. `delete 3`
1. `find study`
1. `bye`

### Expected outcome:

1. `list`

    If there are tasks in the task list.
    
    ```
    Here are the tasks in your list:
    1. [T][✘] study cs2113t
    2. [D][✘] assignment 1 (by: tuesday 2pm)
    3. [E][✘] team project meeting (at: 1 oct 2020, 5pm)
    ```

    If the task list is empty.
    
    ```
    The current tasks list is empty.
    ```
   
1. `todo study CS2113T`

    ```
    😊 Got it. I've added this task:
    [T][✘] study cs2113t
    Now you have 1 task in the list.
    ```
   
1. `deadline assignment 1 /by tuesday 2pm`

    ```
    😊 Got it. I've added this task:
    [D][✘] assignment 1 (by: tuesday 2pm)
    Now you have 2 tasks in the list.
    ```
   
1. `event team project meeting /at 1 Oct 2020, 5pm`

    ```
    😊 Got it. I've added this task:
    [E][✘] team project meeting (at: 1 oct 2020, 5pm)
    Now you have 3 tasks in the list.
    ```
   
1. `done 3`

    ```
    Nice! I've marked this task as done:
    [E][✓] team project meeting (at: 1 oct 2020, 5pm)
    ```
   
1. `delete 3`

    ```
    Noted. I've removed this task:
    [E][✓] team project meeting (at: 1 oct 2020, 5pm)
    Now you have 2 tasks in the list
    ```
   
1. `find assignment`

    ```
    There is 1 matching task in your list:
    2. [T][✘] assignment 1 (by: tuesday 2pm)
    ```
   
1. `bye`

    ```
    All changes saved.
    Bye. Hope to see you again soon!
    ```
   
### Notes

1. `done` and `delete` command can only take in one <task number> at a time.
1. All command keywords (`list`, `todo`, `deadline`, `event`, `done`, `delete`, `find`, `bye`) are case-insensitive.
1. The <task name> parameter of the `todo` command cannot be empty.
1. The <task number> parameter of the `delete` and `done` command cannot be empty.
1. The <task name> and <time> parameter of the `deadline` and `event` command cannot be empty.
1. The <keyword> parameter of the `find` command cannot be empty.
1. The <keyword> parameter of the `find` command is case-insensitive.
1. When finding tasks by a <keyword>, the tasks returned to the found-list have the same <task number> as the ones in the original task list.
1. The application auto saves the task list whenever there is a change of tasks in the task list.
1. The application auto loads the previously saved task list immediately after start-up.