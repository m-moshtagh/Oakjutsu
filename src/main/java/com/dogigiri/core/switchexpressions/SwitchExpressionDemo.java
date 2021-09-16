package com.dogigiri.core.switchexpressions;

import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class SwitchExpressionDemo {
    private static final Scanner inputReader = new Scanner(System.in);

    public static void main(String[] args) {
        var input = inputReader.nextLine().toLowerCase();
        var vehicle = switch (input) {
            case "audi":
                yield "audi";
            case "benz":
                yield "benz";
            case "ford":
                yield "ford";
            case "dodge":
                yield "dodge";
            default:
                yield "";
        };
        LoggerFactory.getLogger(SwitchExpressionDemo.class).info(vehicle);
    }
}
