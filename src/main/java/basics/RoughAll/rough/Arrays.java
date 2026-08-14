package basics.RoughAll.rough;

public class Arrays {

    public static void main(String[] args) {

        int a[] = new int[5];
        for (int i = 0; i <= 4; i++) {
            a[i] = i + 1;
        }

        //Printing
        System.out.println(
                java.util.Arrays.toString(a));//[1, 2, 3, 4, 5]


        //

        int arr[][] = {{1, 2}, {3, 4, 5}, {6, 7, 8, 9}};


        for(int[] i:arr) {
            for(int j:i){
                System.out.print(j+" ");
            }

            System.out.println("");
        }


        //second:

        System.out.println("second");
        for(int i=0;i<arr.length;i++){

            for(int j=0;j<arr[i].length;j++){

                System.out.println(i + " "+j);
                System.out.println("");
                System.out.print(arr[i][j]+" ");
            }

            System.out.println(" ");
        }

        }




    }

