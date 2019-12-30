import csv
from task import Task
from datetime import date

# TODO Add option to show current records
# TODO Add option to search for records of specific task


def main():

    print("\n==== Fish Tank Records App ====\n")

    # leave closes the app when True
    leave = False

    while not leave:
        # lists used for choices
        valid_binary_choices = [1, 2]
        task_list = ['clean', 'feed', 'clean and feed']
        valid_user_choices = [1, 2, 3]

        # loop until user chooses valid choice for date
        date_choice = None
        while date_choice not in valid_binary_choices:
            print("Add a task from today or a previous day?")
            print("Enter '1' for today")
            print("Enter '2' for previous day")
            date_choice = int(input())

        # set the date variable based on user choice
        valid = False
        # date is set to today
        if date_choice == 1:
            date_in = date.today()
        # date is set to custom date
        else:
            while not valid:
                print("When did you do the task?")
                print("Enter in this form: YYYY-MM-DD")
                date_in = input()
                # check validity of date format
                year, month, day = date_in.split("-")
                # check for correct length of parts
                if len(year) == 4 and len(month) == 2 and len(day) == 2:
                    # check for hyphens as separators
                    if date_in[4] == '-' and date_in[7] == '-':
                        # check that values are ints
                        try:
                            yr = int(year)
                            mn = int(month)
                            dy = int(day)
                            # check month and day for valid values
                            if 0 < mn < 13 and 0 < dy < 32:
                                # sets valid to true if date is in correct format
                                valid = True
                            else:
                                print("\nInvalid Format!\n")
                        # catches ValueError from casting values to int
                        except ValueError:
                            print("\nInvalid Format!\n")
                else:
                    print("\nInvalid Format!\n")

        user_input = None

        # loops until user chooses valid choice for task
        while user_input not in valid_user_choices:
            print("\nWhat did you do?")
            print("Enter '1' for clean")
            print("Enter '2' for feed")
            print("Enter '3' for clean and feed")
            user_input = int(input())

        task_in = task_list[user_input - 1]

        # creates task obj of data
        task_obj = Task(date_in, task_in)

        # add new line to csv file with new task item
        with open('fishTankRecord.csv', 'a', newline='') as file_name:
            file_writer = csv.writer(file_name)
            file_writer.writerow([task_obj.date, task_obj.work])
            file_name.close()

        # asks user if more input is needed
        user_input = None
        while user_input not in valid_binary_choices:
            print("Do you want to enter another task?")
            print("Enter '1' for Yes")
            print("Enter '2' for No")
            user_input = int(input())

        # sets leave to true and closes app if no more input is needed
        if user_input == 2:
            leave = True


main()
