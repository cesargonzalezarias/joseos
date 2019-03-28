package es.unileon.prg.date;

public class Date {

	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) throws DateException{
		if(this.isDayRight(day,month)){
			this.day = day;
			this.month = month;
			this.year = year;
			}
	
		else{
			throw new DateException("La siguiente fecha no es valida: " +day+ "-" +month+ "-"+year);
			
		}
	}

	public String toString(){
		StringBuffer salida = new StringBuffer();
		
		salida.append("Dia: "+this.day);
		salida.append("Mes: "+this.month);
		salida.append("Año: "+this.year);
		return salida.toString();
	}	
	
	private int daysOfMonth(){
		int number = 0;
		switch (month){
		case 1://next
		case 3://next
		case 5://next
		case 7://next
		case 8://next
		case 10://next
		case 12:
			number = 31;
		break;
		case 2:
			number = 28;
		break;
		case 4://next
		case 6://next
		case 9://next
		case 11:
			number = 30;
		default: 
			number = 33333;
		}
	return number;
	}
	
	private boolean isDayRight(int day,int month){
		boolean right = true;
		switch(month){
		case 1://next
		case 3://next
		case 5://next
		case 7://next
		case 8://next
		case 10://next
		case 12:
			if((day>31)||(day<0)){
				right = false;
			}
			break;
		case 2:
			if((day>28)||(day<0)){
				right = false;
			}
			break;
		case 4://next
		case 6://next
		case 9://next
		case 11:
			if((day>30)||(day<0)){
				right = false;
			}
		default:
			right = false;
		}	
		return right;
	}
	
	public String seasonMonth (){
		String season = " ";
		switch (month){
		case 1://next
		case 2://next
		case 12:
			season = "Invierno";
		break;
		case 3://next
		case 4://next
		case 5:
			season = "Primavera";
		break;
		case 6://next
		case 7://next
		case 8:
			season = "Verano";
		break;
		case 9://next
		case 10://next
		case 11:
			season = "Otonyo";
		break;
		}
		return season;
	}
	
	public String nameOfMonth(){
		return this.nameOfMonth(this.month);
	}
	
	private String nameOfMonth(int month){
		String mes = " ";
		switch (month){
		case 1 : 
			mes = "Enero";
		break;
		case 2 :
			mes = "Febrero";
		break;
		case 3 : 
			mes = "Marzo";
		break;
		case 4 :
			mes = "Abril";
		break;
		case 5 : 
			mes = "Mayo";
		break;
		case 6 :
			mes = "Junio";
		break;
		case 7 : 
			mes = "Julio";
		break;
		case 8 : 
			mes = "Agosto";
		break;
		case 9 :
			mes = "Septiembre";
		break;
		case 10:	
			mes = "Octubre";
		break;
		case 11 : 
			mes = "Noviembre";
		break;
		case 12 :
			mes = "Diciembre";
		break;
		}
		return mes;
	}
	
	public void setDay(int day){
		if(this.isDayRight(day,this.month)){
			this.day = day;
		}	
	}
	public void setMonth(int month){
		this.month = month;
	}
	public void setYear(int year){	
		this.year = year;
	}
	
	public Date (Date anotherDate){
		this.day = anotherDate.getDay();
		this.month = anotherDate.getMonth();
		this.year = anotherDate.getYear();
		}
	
	public int getDay(){
		return day;
		}
	
	public int getMonth(){
		return month;
		}
	
	public int getYear(){
		return year;
		}
	
	public boolean isSameYearIf(Date anotherDate){
		if(this.year==anotherDate.getYear()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isSameMonthIf(Date anotherDate){
		if(this.month==anotherDate.getMonth()){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean isSameDayIf(Date anotherDate){
		if(this.day==anotherDate.getDay()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isSameYear(Date anotherDate){
		return this.year == anotherDate.getYear();
	}
	
	public boolean isSameMonth(Date anotherDate){
		return this.month == anotherDate.getMonth();
	}	
	
	public boolean isSameDay(Date anotherDate){
		return this.day == anotherDate.getDay();
	}

	public boolean isSameIf(Date anotherDate){
		if((isSameYearIf(anotherDate))&&(isSameMonthIf(anotherDate))&&(isSameDayIf(anotherDate))){
			return true;
		}
		else{
			return false;
		}
	}

	private int daysOfMonth(int m){
		int number = 0;
		switch (m){
		case 1://next
		case 3://next
		case 5://next
		case 7://next
		case 8://next
		case 10://next
		case 12:
			number = 31;
		break;
		case 2:
			number = 28;
		break;
		case 4://next
		case 6://next
		case 9://next
		case 11:
			number = 30;
		default: 
			number = 33333;
		}
		return number;
	}
	 
	
	public String monthsRemaining(){
		int mes = getMonth();
		StringBuffer salida = new StringBuffer();
		Date ayuda;
		ayuda = new Date(this);
 
		for (int i=mes+1;i<=12;i++){
			ayuda.setMonth(i);
			salida.append(ayuda.nameOfMonth()+"\n");
			}
		return salida.toString();
	}

	public String diasFinMes(){
		StringBuffer exit=new StringBuffer();
		int nDias=30;
		int i=day+1;
		if (month ==1||month==3||month==5||month==7||month==8||month==10||month==12){
			nDias=31;
		}
		else if (month==2){
			nDias=28;
		}
		while(i<=nDias){
			exit.append(i+"-"+month+"-"+year+"\n");
			i++;
		}
		return exit.toString();
	}
	
	public String mesNumDias(){
		StringBuffer exit=new StringBuffer();
		int i=month+1;
		while(i<13){
			if(daysOfMonth(i)==daysOfMonth(month)){
				exit.append(i+" ");
			}
			i++;
		}
		return exit.toString();
	}
	
}





