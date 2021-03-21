package Num1_dataStructure.Num1_sparseArray;

import java.util.Arrays;

/**
 * 稀疏数组部分
 *  当一个数组中大部分元素为０，或者为同一个值的数组时，可以使用稀疏数组来保存该数组。
 *  稀疏数组的处理方法是:
 *      记录数组一共有几行几列，有多少个不同的值
 *      把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模
 */
public class sparseArray_Test {
    public static void main(String[] args) {

        //创建原始的二维数组 11*11
        //0表示没有旗子，1表示黑子，2表示白子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][4] = 2;
        chessArr[4][5] = 3;

        //输出原始的二维数组
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                System.out.printf("%d\t", chessArr[i][j]);
                if (j == chessArr[i].length - 1) {
                    System.out.println();
                }
            }
        }
        System.out.println("=========================================");
        //将二维数组转为稀疏数组
        //先遍历二维数组，得到非零数据的个数
        int sum = 0;

        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sum += 1;
                }
            }
        }
        System.out.println("sum : " + sum);

        //创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int index = 1;
        //遍历二维数组，将非零的值存放到sparseArr中
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sparseArr[index][0] = i;
                    sparseArr[index][1] = j;
                    sparseArr[index][2] = chessArr[i][j];

                    index++;
                }
            }
        }

        //输出稀疏数组的形式
        System.out.println("=========================================");
        System.out.println("得到的稀疏数组：");
        for (int i = 0; i < sum + 1; i++) {
            System.out.printf("%d\t%d\t%d\t", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
            System.out.println();
        }
//----------------------------------------------------------------------------------------------------------------------//

        System.out.println("=========================================");
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //读取稀疏数组后几行的数据，并赋给原始的二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("恢复后的二维数组：");
        for (int i = 0;i < chessArr2.length;i++) {
            for (int data:chessArr2[i]){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}

