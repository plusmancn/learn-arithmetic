package cn.plusman.design.memento;

import java.util.Scanner;
import java.util.Stack;

/**
 * cn.plusman.design.memento
 *
 * @author plusman
 * @since 2020/11/8
 */
public class CommandV1 {
    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.next();
            switch (input) {
                case ":list":
                    System.out.println(inputText.getText());
                    break;
                case ":undo":
                    Snapshot snapshot = snapshotHolder.popSnapshot();
                    inputText.restoreSnapshot(snapshot);
                    break;
                default:
                    snapshotHolder.pushSnapshot(inputText);
                    inputText.append(input);
                    break;
            }
        }
    }
}

class InputText {
    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void append(String input) {
        this.text.append(input);
    }

    public void restoreSnapshot(Snapshot snapshot) {
        this.text.replace(0, this.text.length(), snapshot.getText());
    }
}

class Snapshot {
    private String text;

    public Snapshot(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class SnapshotHolder {
    private Stack<Snapshot> snapshots = new Stack<>();

    public Snapshot popSnapshot() {
        return snapshots.pop();
    }

    public void pushSnapshot(InputText inputText) {
        snapshots.push(new Snapshot(inputText.getText()));
    }
}
