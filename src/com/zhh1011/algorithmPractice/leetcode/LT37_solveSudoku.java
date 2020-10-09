package com.zhh1011.algorithmPractice.leetcode;

import java.util.*;

public class LT37_solveSudoku {
    private static Map<String,ArrayList<Integer>> map = new HashMap<>();
    private static final int CHECK_CASE = 1+2+3+4+5+6+7+8+9;
    private static final ArrayList<Integer> CHECK_CASE_1 = new ArrayList<>();
    static {
        CHECK_CASE_1.add(1);
        CHECK_CASE_1.add(2);
        CHECK_CASE_1.add(3);
        CHECK_CASE_1.add(4);
        CHECK_CASE_1.add(5);
        CHECK_CASE_1.add(6);
        CHECK_CASE_1.add(7);
        CHECK_CASE_1.add(8);
        CHECK_CASE_1.add(9);
    }
    public static void getResult(char[][] input){
        int[][] board = dealInput(input);
        do{
            checkRoleOne(board);
            checkRoleTwo(board);
            checkRoleThree(board);
            updateBoard(board);

            System.out.println("");
            for(int[] a:board){
                System.out.println(Arrays.toString(a));
            }
        }while (!map.isEmpty());
    }
    private static int[][] dealInput(char[][] board){
        int[][] output = new int[9][9];
        for(int i=0;i < 9;i++){
            for(int j =0;j < 9;j++){
                char temp = board[i][j];
                switch (temp){
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        output[i][j] = temp-'0';
                        break;
                    case '.':
                        output[i][j] = -1;
                        break;
                    default:
                        break;
                }
            }
        }
        return output;
    }

    private static void checkRoleOne(int[][] board){
        Deque<String> stack = new LinkedList<>();
        for(int i = 0; i < 9;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0;j< 9;j++){
                int temp = board[i][j];
                switch (temp){
                    case -1:
                        stack.push(""+i+j);
                        break;
                    default:
                        list.add(temp);
                        break;
                }
            }
            while (!stack.isEmpty()){
                ArrayList<Integer> temp = null;
                if(!map.containsKey(stack.peek())) {
                    temp = new ArrayList<>(CHECK_CASE_1);
                    temp.removeAll(list);
                }else {
                    temp  = map.get(stack.peek());
                    ArrayList<Integer> temp1 = new ArrayList<>(CHECK_CASE_1);
                    temp1.removeAll(list);
                    temp.retainAll(temp1);
                }
                map.put(stack.pop(),temp);
            }
        }
    }

    private static void checkRoleTwo(int[][] board){
        Deque<String> stack = new LinkedList<>();
        for(int i = 0; i < 9;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0;j< 9;j++){
                int temp = board[j][i];
                switch (temp){
                    case -1:
                        stack.push(""+j+i);
                        break;
                    default:
                        list.add(temp);
                        break;
                }
            }
            while (!stack.isEmpty()){
                ArrayList<Integer> temp = null;
                if(!map.containsKey(stack.peek())) {
                    temp = new ArrayList<>(CHECK_CASE_1);
                    temp.removeAll(list);
                }else {
                    temp = map.get(stack.peek());
                    ArrayList<Integer> temp1 = new ArrayList<>(CHECK_CASE_1);
                    temp1.removeAll(list);
                    temp.retainAll(temp1);
                }
                map.put(stack.pop(),temp);
            }
        }
    }

    private static void checkRoleThree(int[][] board){
        Deque<String> stack = new LinkedList<>();
        for(int x = 0; x < 9;x+=3){
            for(int y = 0; y < 9; y+=3){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = 0; i < 3;i++){
                    for(int j = 0; j < 3;j++){
                        int temp = board[x+i][y+j];
                        switch (temp){
                            case -1:
                                int tempx = x+i;
                                int tempy = y+j;
                                stack.push(""+tempx+tempy);
                                break;
                            default:
                                list.add(temp);
                                break;
                        }
                    }
                }
                while (!stack.isEmpty()){
                    ArrayList<Integer> temp = null;
                    if(!map.containsKey(stack.peek())) {
                        temp = new ArrayList<>(CHECK_CASE_1);
                        temp.removeAll(list);
                    }else {
                        temp = map.get(stack.peek());
                        ArrayList<Integer> temp1 = new ArrayList<>(CHECK_CASE_1);
                        temp1.removeAll(list);
                        temp.retainAll(temp1);
                    }
                    map.put(stack.pop(),temp);
                }
            }
        }
    }

    private static void updateBoard(int[][] board){
        ArrayList<String> temp = new ArrayList<>();
        for(Map.Entry<String,ArrayList<Integer>> entry:map.entrySet()){
            if(entry.getValue().size()==1){
                int x = entry.getKey().charAt(0) -'0';
                int y = entry.getKey().charAt(1) -'0';
                board[x][y] = entry.getValue().get(0);
                temp.add(entry.getKey());
            }
        }
        for(String s:temp){
            map.remove(s);
        }
    }

    public static void main(String[] args){
        char[][] input = new char[][]{
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}};
        getResult(input);
    }
}
