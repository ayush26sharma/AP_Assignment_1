package com.company;

import java.util.*;

public class Backpack {
    private final static ArrayList<Comment> commentList = new ArrayList<>();
    private final static ArrayList<LectureMaterial> slidesList = new ArrayList<>();
    private final static ArrayList<LectureMaterial> videosList = new ArrayList<>();
    private final static ArrayList<Assessment> allAssignments = new ArrayList<>();
    private final static ArrayList<Assessment> allQuizzes = new ArrayList<>();
    public static void run(){
        Scanner sc = new Scanner(System.in);
        Instructor.autoGenerate();
        Student.autoGenerate();
        while (true) {
            System.out.println("___________________________________________________");
            System.out.println("Welcome to the Backpack");
            System.out.println("1. Enter as an instructor");
            System.out.println("2. Enter as a student");
            System.out.println("3. Exit");
            System.out.print("Enter your command: ");
            int command = sc.nextInt();
            if (command == 1) {
                Instructor.displayList();
                System.out.print("Choose id: ");
                int id = sc.nextInt();
                while(true){
                if (id < Instructor.professors.size()) {
                    System.out.println("Welcome " + User.professors.get(id).getName());
                    Instructor currentInstructor = User.professors.get(id);
                    Instructor.displayMenu();
                    System.out.print("Enter option: ");
                    int option = sc.nextInt();
                    if (option == 1) {
                        System.out.println("1. Add lecture slide\n" +
                                "2. Add lecture video");
                        int com = sc.nextInt();
                        if (com == 1) {
                            System.out.print("Enter topic of slides: ");
                            sc.nextLine();
                            String topic = sc.nextLine();
                            System.out.print("Enter number of slides: ");
                            int slides = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter content: ");
                            String[] slideArray = new String[slides];
                            for (int i = 0; i < slides; i++) {
                                System.out.print("Enter content of slide " + (i + 1) + ": ");
                                slideArray[i] = sc.nextLine();
                            }
                            Date d = new Date();
                            LectureMaterial lecSlide = new LectureSlide(topic, slides, slideArray, currentInstructor, d);
                            slidesList.add(lecSlide);
                        } else if (com == 2) {
                            System.out.print("Enter topic of video: ");
                            sc.nextLine();
                            String topic = sc.nextLine();
                            System.out.print("Enter filename of video: ");
                            String name = sc.nextLine();
                            if (name.endsWith(".mp4")) {
                                Date d = new Date();
                                LectureMaterial lecVideo = new LectureVideo(topic, name, currentInstructor, d);
                                videosList.add(lecVideo);
                            } else {
                                System.out.println("Invalid file format.");
                            }
                        } else {
                            System.out.println("Invalid input.");
                        }
                    } else if (option == 2) {
                        System.out.println("1. Add Assignment\n" +
                                "2. Add Quiz");
                        int com = sc.nextInt();
                        if (com == 1) {
                            System.out.print("Enter problem statement: ");
                            sc.nextLine();
                            String problemStatement = sc.nextLine();
                            System.out.print("Enter max marks: ");
                            int marks = sc.nextInt();
                            Date d = new Date();
                            Assessment assignment = new Assignment(problemStatement, marks, d, currentInstructor);
                            assignment.add(assignment, allAssignments);

                        } else if (com == 2) {
                            System.out.print("Enter quiz question: ");
                            sc.nextLine();
                            String problemStatement = sc.nextLine();
                            Date d = new Date();
                            int maxMarks = 1;
                            Assessment quiz = new Quiz(problemStatement, maxMarks, d, currentInstructor);
                            quiz.add(quiz, allQuizzes);

                        } else {
                            System.out.println("Invalid input.");
                        }
                    } else if (option == 3) {
                        LectureMaterial.viewLectureMaterial(videosList, slidesList);
                    } else if (option == 4) {
                        System.out.println("Assignments: ");
                        Assessment.view(allAssignments);                 //problem
                        System.out.println("Quizzes: ");
                        Assessment.view(allQuizzes);
                    } else if (option == 5) {
                        System.out.println("List of Assignments: ");
                        for (Assessment S : allAssignments) {
                            System.out.print("ID: " + allAssignments.indexOf(S) + " ");
                            S.display();
                        }
                        System.out.println("List of open Quizzes: ");
                        for (Assessment S : allQuizzes) {
                            System.out.print("ID: " + allQuizzes.indexOf(S) + " ");
                            S.display();
                        }
                        System.out.println("Enter type (Assignment/ Quiz): ");
                        String type = sc.next();
                        sc.nextLine();
                        System.out.println("Enter ID of assessment: ");
                        int ID = sc.nextInt();
                        if (type.equals("Quiz")) {
                            Assessment s = allQuizzes.get(ID);
                            System.out.println("Choose ID from these ungraded submissions");
                            for (Student student : User.students) {
                                for (Submission sub : student.getSubmittedQuizzes()) {
                                    if (sub.getS() == s && !sub.isGraded()) {
                                        System.out.println(User.students.indexOf(student) + ". " + student.getName());
                                    }
                                }
                            }
                            int x = sc.nextInt();
                            Student stu = User.students.get(x);
                            for (Submission sub : stu.getSubmittedQuizzes()) {
                                if (sub.getS() == s && !sub.isGraded()) {
                                    System.out.println("Submission: " + sub.getName());
                                    System.out.println("_____________________________________________");
                                    System.out.println("Max Marks: " + sub.getS().getMaxMarks());
                                    System.out.print("Marks scored: ");
                                    int a = sc.nextInt();
                                    if (a > sub.getS().getMaxMarks()) {
                                        System.out.println("Invalid input");
                                    } else {
                                        sub.setGrade(a);
                                        sub.setGradedBy(currentInstructor);
                                        sub.setGraded(true);
                                    }
                                }
                            }
                        } else if (type.equals("Assignment")) {
                            Assessment s = allAssignments.get(ID);
                            System.out.println("Choose ID from these ungraded submissions");
                            for (Student student : User.students) {
                                for (Submission sub : student.getSubmittedAssignment()) {
                                    if (sub.getS() == s && !sub.isGraded()) {
                                        System.out.println(User.students.indexOf(student) + ". " + student.getName());
                                    }
                                }
                            }
                            int x = sc.nextInt();
                            Student stu = User.students.get(x);
                            for (Submission sub : stu.getSubmittedAssignment()) {
                                if (sub.getS() == s && !sub.isGraded()) {
                                    System.out.println("Submission: " + sub.getName());
                                    System.out.println("_____________________________________________");
                                    System.out.println("Max Marks: " + sub.getS().getMaxMarks());
                                    System.out.print("Marks scored: ");
                                    int a = sc.nextInt();
                                    if (a > sub.getS().getMaxMarks()) {
                                        System.out.println("Invalid input");
                                    } else {
                                        sub.setGrade(a);
                                        sub.setGradedBy(currentInstructor);
                                        sub.setGraded(true);
                                    }
                                }
                            }
                        }
                    } else if (option == 6) {
                        System.out.println("List of open Assignments: ");
                        for (Assessment S : allAssignments) {
                            if (S.isOpen()) {
                                System.out.print("ID: " + allAssignments.indexOf(S) + " ");
                                S.display();
                            }
                        }
                        System.out.println("List of open Quizzes: ");
                        for (Assessment S : allQuizzes) {
                            if (S.isOpen()) {
                                System.out.print("ID: " + allQuizzes.indexOf(S) + " ");
                                S.display();
                            }
                        }
                        System.out.println("Enter type (Assignment/ Quiz): ");
                        String type = sc.next();
                        sc.nextLine();
                        System.out.println("Enter ID of assessment: ");
                        int ID = sc.nextInt();
                        if (type.equals("Quiz")) {
                            Assessment s = allQuizzes.get(ID);
                            s.setOpen(false);
                            s.close(s);
//                            for (Student st: User.students) {
//                                for (:) {
//
//                                }
//                                Submission sub = new Submission(s,st,"Missed Assignment");
//                                sub.setGrade(0);
//                                sub.setGraded(true);
//                                sub.setGradedBy(currentInstructor);
//                            }
                        } else if (type.equals("Assignment")) {
                            Assessment s = allAssignments.get(ID);
                            s.setOpen(false);
                            s.close(s);
//
//                            for (Student st: User.students) {
//
//
//                            }
                        }
                    } else if (option == 7) {
                        for (Comment i : User.comments) {
                            i.display();
                        }
                    } else if (option == 8) {
                        System.out.println("Enter comment: ");
                        sc.nextLine();
                        String comment = sc.nextLine();
                        Date date = new Date();
                        Comment comment1 = new Comment(comment, currentInstructor, date);
                        User.comments.add(comment1);
                    } else if (option == 9) {
                        break;
                    }
                } else {
                    System.out.println("Invalid ID.");
                }
            }
            } else if (command == 2) {
                Student.displayList();
                System.out.print("Choose id: ");
                int id = sc.nextInt();
                while(true) {
                    if (id < Instructor.professors.size()) {
                        System.out.println("Welcome " + User.students.get(id).getName());
                        Student currentStudent = User.students.get(id);
                        Student.displayMenu();
                        System.out.print("Enter option: ");
                        int option = sc.nextInt();
                        if (option == 1) {
                            LectureMaterial.viewLectureMaterial(videosList, slidesList);
                        } else if (option == 2) {
                            System.out.println("Assignments: ");
                            Assessment.view(allAssignments);
                            System.out.println("Quizzes: ");
                            Assessment.view(allQuizzes);
                        } else if (option == 3) {
                            if (!(currentStudent.getPendingAssignment().isEmpty() && currentStudent.getPendingQuizzes().isEmpty())) {
                                System.out.println("Pending Assignments:");
                                for (Assessment S : currentStudent.getPendingAssignment()) {
                                    System.out.print("ID: " + currentStudent.getPendingAssignment().indexOf(S) + " ");
                                    S.display();
                                }
                                System.out.println("Pending Quizzes: ");
                                for (Assessment S : currentStudent.getPendingQuizzes()) {
                                    System.out.print("ID: " + currentStudent.getPendingQuizzes().indexOf(S) + " ");
                                    S.display();
                                }
                                System.out.println("Enter type (Assignment/ Quiz): ");
                                String type = sc.next();
                                System.out.println("Enter ID of assessment: ");
                                int ID = sc.nextInt();
                                if (type.equals("Assignment")) {
                                    System.out.println("Enter filename of assignment: ");
                                    sc.nextLine();
                                    String filename = sc.nextLine();
                                    if (filename.endsWith(".zip")) {
                                        Submission s = new Submission(allAssignments.get(ID), currentStudent, filename);
                                        currentStudent.getPendingAssignment().get(ID).setSubmitted(true);
                                        currentStudent.getPendingAssignment().remove(allAssignments.get(ID));
                                        currentStudent.getSubmittedAssignment().add(s);
                                    } else {
                                        System.out.println("Invalid input.");
                                    }
                                } else if (type.equals("Quiz")) {
                                    Quiz a = (Quiz) allQuizzes.get(ID);
                                    System.out.println("Question: " + a.getQuestion());
                                    sc.nextLine();
                                    String filename = sc.nextLine();
                                    Submission s = new Submission(allQuizzes.get(ID), currentStudent, filename);
                                    currentStudent.getPendingQuizzes().get(ID).setSubmitted(true);
                                    currentStudent.getPendingQuizzes().remove(allQuizzes.get(ID));
                                    currentStudent.getSubmittedQuizzes().add(s);
                                }
                            }
                            else{
                                System.out.println("No pending assessments");
                            }
                        } else if (option == 4) {
                            System.out.println("Graded Assignments:");
                            for (Submission i : currentStudent.getSubmittedAssignment()) {
                                if (i.isGraded()) {
                                    System.out.println("Submission: " + i.getName());
                                    System.out.println("Marks Scored: " + i.getGrade());
                                    System.out.println("Graded by: " + i.getGradedBy().getName());
                                }
                            }
                            System.out.println("________________________________________________");
                            System.out.println("Graded Quizzes");
                            for (Submission i : currentStudent.getSubmittedQuizzes()) {
                                if (i.isGraded()) {
                                    System.out.println("Submission: " + i.getName());
                                    System.out.println("Marks Scored: " + i.getGrade());
                                    System.out.println("Graded by: " + i.getGradedBy().getName());
                                }
                            }
                            System.out.println("________________________________________________");
                            System.out.println("Ungraded Assignments");
                            for (Submission i : currentStudent.getSubmittedAssignment()) {
                                if (!i.isGraded()) {
                                    System.out.println("Submission: " + i.getName());
                                }
                            }
                            System.out.println("________________________________________________");
                            System.out.println("Ungraded Quizzes");
                            for (Submission i : currentStudent.getSubmittedQuizzes()) {
                                if (!i.isGraded()) {
                                    System.out.println("Submission: " + i.getName());
                                }
                            }
                            System.out.println("________________________________________________");
                        } else if (option == 5) {
                            for (Comment i : User.comments) {
                                i.display();
                            }
                        } else if (option == 6) {
                            System.out.println("Enter comment: ");
                            sc.nextLine();
                            String comment = sc.nextLine();
                            Date date = new Date();
                            Comment comment1 = new Comment(comment, currentStudent, date);
                            User.comments.add(comment1);
                        } else if (option == 7) {
                            break;
                        }
                    }
                }
            } else if (command == 3) {
                System.out.println("___________________________________________________");
                break;
            } else {
                System.out.println("Invalid command. Please try again. ");
            }
        }
    }
}
