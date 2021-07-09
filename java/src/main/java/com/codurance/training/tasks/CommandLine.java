package com.codurance.training.tasks;

import java.time.LocalDate;

public class CommandLine {
    private String textLine;

    public CommandLine(String textLine) {
        this.textLine = textLine;
    }
    /*
     * [CMD]  [nodetype]  [projectname]
     *  add      project     training
     * [CMD]   [nodetype]           [taskdescription]
     * add        task     training Four Elements of Simple Design
     * */
    public Command getCommand() {
        String[] textCommands = textLine.split(" ",4);
        Command command;

        CommandAction commandAction = CommandAction.valueOf(textCommands[0].toUpperCase());
        switch (commandAction){
            case SHOW:
            case HELP:
            case QUIT:
                command = new Command(commandAction);
                break;
            case CHECK:
            case UNCHECK:
                command = new Command(
                        commandAction,
                        new TaskId(Integer.parseInt(textCommands[1])));
                break;
            case ADD:
                NodeType nodeType = NodeType.valueOf(textCommands[1].toUpperCase());

                if(NodeType.PROJECT.equals(nodeType)) {
                    command = new Command(
                            commandAction,
                            nodeType,
                            new ProjectName(textCommands[2]));
                } else {
                    command = new Command(
                            commandAction,
                            nodeType,
                            new ProjectName(textCommands[2]),
                            new TaskDescription(textCommands[3]));
                }
                break;
            case DEADLINE:
                command = new Command(
                        commandAction,
                        new TaskId(Integer.parseInt(textCommands[1])),
                        new DeadLine(LocalDate.parse(textCommands[2])));
                break;
            default:
                command = null;
                break;
        }
        return command;
    }
}