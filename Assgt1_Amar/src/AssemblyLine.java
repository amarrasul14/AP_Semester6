
public class AssemblyLine {
		
		int a[][];
		int t[][];
		int f1[], f2[];
		
		int e1, e2;
		int x1, x2;
		int result, line;
		
		int n;
	

public void fastestWay(int a[][], int t[][], int e1, int e2, int x1, int x2){
	
    	n= 4;
    	
    	f1= new int[n];
    	f2= new int[n];
    	int[] l1= new int[n];
    	int[] l2= new int[n];
    	
    	f1[0]=e1+a[0][1];
    	f2[0]=e2+a[1][1];
	
    
	for(int j=1;j<n;j++){
		
		if(f1[j-1]+a[0][j]<=f2[j-1]+t[1][j-1]+a[0][j]){
			f1[j]=f1[j-1]+a[0][j];
			l1[j]=1;
		}
		else{
			f1[j]=f2[j-1]+t[1][j-1]+a[0][j];
			l1[j] = 2;
			}

		
		if(f2[j-1]+a[1][j]<=f1[j-1]+t[0][j-1]+a[1][j]){
			f2[j]=f2[j-1]+a[1][j];
			l2[j]=2;	
		}
		else{
			f2[j]=f1[j-1]+t[0][j-1]+a[1][j];
			l2[j]=1;		
		}
	}	
	
		if(f1[n-1]+x1<=f2[n-1]+x2){
			result=f1[n-1]+x1;
			line=1;
			
		}
		else{
			result=f2[n-1]+x2;
			line=2;
		}
	
	System.out.println("Total cost:"+ result);
	System.out.println("Assembly line taken: "+ line);
}
		
public static void main(String[] args){
		
	int e1 = 15;
	int e2 = 17;
	int a[][] = {{2, 9, 8, 1},
            {1, 1, 7, 10}};
 	int t[][] = {{0, 3, 9, 11},
            {0, 7, 6, 2}};
	int x1= 5;
    int x2=10;
    
	AssemblyLine ws = new AssemblyLine();
	ws.fastestWay(a, t, e1, e2, x1, x2);	
	
}//main
	
	
}
