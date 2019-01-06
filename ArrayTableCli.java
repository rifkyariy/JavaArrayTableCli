import java.util.Arrays;
import java.util.Scanner;

public class ArrayTableCli {
    double[][] tableVal = new double[4][3];
    double[] programAverage = new double[4];
    double[] studentAverage = new double[3];
    double[] tempMax = new double[2];
    double[] tempMin = new double[2];

    public ArrayTableCli(){
        prntln("=========================================");
        prntln("=             Selamat Datang            =");
        prntln("=========================================");
        inputVal();
        programAverage();
        studentAverage();
        outputTable();

        MaxAverage(programAverage);
        prntln("Nilai rata rata mata pelajaran paling tinggi ialah : Pelajaran ke "+((Math.round(tempMax[0]))+1)+" dengan Nilai : "+tempMax[1]);

        MinAverage(programAverage);
        prntln("Nilai rata rata mata pelajaran paling rendah ialah : Pelajaran ke "+((Math.round(tempMin[0]))+1)+" dengan Nilai : "+tempMin[1]);

        MaxAverage(studentAverage);
        prntln("Nilai rata rata siswa paling tinggi ialah : Siswa ke "+((Math.round(tempMax[0]))+1)+" dengan Nilai : "+tempMax[1]);

        MinAverage(studentAverage);
        prntln("Nilai rata rata siswa paling rendah ialah : Siswa ke "+((Math.round(tempMin[0]))+1)+" dengan Nilai : "+tempMin[1]);


    }

    public void prnt(String value){
        System.out.print(value);
    }

    public void prntln(String value){
        System.out.println(value);
    }

    public void inputVal(){
        Scanner programIn = new Scanner(System.in);
        for (int program = 0; program < tableVal.length; program++){
            for (int student = 0; student < tableVal[program].length; student++){
                prntln(" Input Nilai Pelajaran "+(program+1)+" Untuk Siswa ke "+ (student+1) +": ");
                double inVal = programIn.nextDouble();
                if ( inVal >= 0 && inVal <= 100){
                    try {
                        tableVal[program][student]= inVal;
                    } catch (Exception e){
                        prnt("Whoops ,Salah Input Pak Bro");
                    }
                }else {
                    prnt("Whoops ,Salah Input Pak Bro");
                    System.exit(0);
                }
            }
        }
    }

    public void programAverage(){
        for (int i = 0; i<tableVal.length; i++){
            double average = (tableVal[i][0]+tableVal[i][1]+tableVal[i][2])/tableVal[i].length;
            programAverage[i] = Math.round(average);

        }
    }

    public void studentAverage(){
        for (int i = 0; i<3; i++){
            double average = (tableVal[0][i]+tableVal[1][i]+tableVal[2][i]+tableVal[3][i])/tableVal.length;
            studentAverage[i] = Math.round(average);

        }
    }

    public void MaxAverage(double array[]){
        double max = array[0];

        for (int i = 0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
            tempMax[0] = i;
            tempMax[1] = max;
        }
    }

    public void MinAverage(double array[]){
        double min = array[0];

        for (int i = 0; i < array.length; i++){
            if (array[i] < min){
                min = array[i];
            }
            tempMin[0] = i;
            tempMin[1] = min;
        }
    }


    public void outputTable(){
        prntln("-----------------------------------------------------------------------------------------------------------");
        System.out.printf("%12s %20s %5s %5s %5s %4s", "Siswa |", "Pelajaran ke 1 |  ", "Pelajaran ke 2 |  ", "Pelajaran ke 3 |  ", "Pelajaran ke 4 |  " , "Rata Rata Siswa ");prntln("");
        prntln("-----------------------------------------------------------------------------------------------------------");

        for (int student = 0; student < 3; student++){
            System.out.printf("%12s %18s %18s %18s %18s %18s", "Siswa ke "+(student+1)+" |", ""+tableVal[0][student]+" |",""+tableVal[1][student]+" |", ""+tableVal[2][student]+" |", ""+tableVal[3][student]+" |", ""+studentAverage[student]+" ");prntln("");
        }

        prntln("-----------------------------------------------------------------------------------------------------------");
        System.out.printf("%12s %18s %18s %18s %18s %18s ", "Rata Rata |", ""+programAverage[0]+" |", ""+programAverage[1]+" |", ""+programAverage[2]+" |", ""+programAverage[3]+" |" , "(-,-) ");prntln("");
        prntln("-----------------------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args){
        ArrayTableCli initTable = new ArrayTableCli();
    }
}


