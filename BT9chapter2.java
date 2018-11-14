package gui;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;


public class BT9chapter2 {
	
	//dùng để chứa danh sách sinh viên kiểu dữ liệu students
	Vector<Students> list = new Vector<Students>();
	
	public BT9chapter2() {
		
		
		while(true) {
			System.out.println("=================================================");
			System.out.println("|--------CHUONG TRINH QUAN LI SINH VIEN------   |");
			System.out.println("|1. Nhap danh sach sinh vien                    |");
			System.out.println("|2. Xem danh sach sinh vien                     |");
			System.out.println("|3. Sap xep diem trung binh tang dan            |");
			System.out.println("|4. Tim sinh vien co diem toan cao nhat         |");
			System.out.println("|5. Tim sinh vien co diem toan thap nhat        |");
	     	System.out.println("|6. Tim sinh vien co tuoi lon hon 23            |");
	        System.out.println("|7. Tim sinh vien co que o Da Nang              |");
			System.out.println("|8. Tim sinh vien co ho Nguyen                  |");
			System.out.println("-------------------------------------------------");
			
			int num;
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Nhap so de chon chuc nang");
			num= keyboard.nextInt();
			
			switch (num) {
				case 1:
					NhapSV();
					break;
				case 2:
					inThongTin();
					break;
				case 3:
					sort();
					break;
				case 4:
					maxToan();
					break;
				case 5:
					minToan();
					break;
				case 6:
					tuoi();
					break;
				case 7:
				    diachi();
					break;
				case 8:
					ten();
					break;
				case 9:	
					System.out.println("chuong trinh ket thuc ");
					return;
			
			}
		}
	}
	
	public void NhapSV() {
		int num = 0;
		Scanner key = new Scanner(System.in);
		
		System.out.println("Nhap danh sach sinh vien");
		
		num = key.nextInt();
		for(int i=1;i<= num;i++)
		{
			System.out.println("Nhap thong tin sinh vien thu "+i);
			System.out.println("Nhap ten");
			key.nextLine();
			String ten = key.nextLine();
			System.out.println("Nhap dia chi");
			String diachi= key.nextLine();
			System.out.println("Nhap tuoi");
			int tuoi= key.nextInt();
			System.out.println("Nhap diem toan");
			float toan= key.nextFloat();
			System.out.println("Nhap diem li");
			float li= key.nextFloat();
			System.out.println("Nhap diem van");
			float van= key.nextFloat();
			
			Students st = new Students(ten, diachi, tuoi, toan, li, van);//sau khi nhập thông tin, tạo đối tượng sinh viên
			list.add(st); //lưu đối tượng sinh viên vào danh sách list
			
		}
	}
	
	public void inThongTin() {
		System.out.println("--------Xem Thong Tin Sinh Vien-----------");
		
		Enumeration Thao = list.elements();//lấy sinh viên ở danh sách vector và lưu trữ ở Thao
		
		int index = 1;// duyệt từng phần tử của Thao
		while (Thao.hasMoreElements() == true) {
			// lay tung phan tu cua Thao ép kiểu lai Students
			Students sts = (Students)Thao.nextElement();
			System.out.println("Ten: " + sts.hoten);
			System.out.println( " Tuoi: " + sts.tuoi);
			System.out.println(" Dia Chi: " + sts.diaChi);
			System.out.println(" DiemTB: " + sts.tb);
		}
		System.out.println("----------HET---------");
		
	}
	
	public void sort() {
		
		System.out.println("----------Sap Xep Sinh Vien-----------");
		//đổ dữ liệu từ vector vào mảng để gọi hàm sort sắp xếp mảng
		Students[] sts = new Students[list.size()];
		for (int i = 0; i < list.size(); i++) {
			sts[i] = list.elementAt(i);
		}
		//sắp xếp mảng
		Arrays.sort(sts);
		
		for (int i = 0; i < sts.length; i++) {
			System.out.println("Ten: " + sts[i].hoten +" Tuoi: " + sts[i].tuoi + " Dia Chi: " + sts[i].diaChi + " DiemTB: " + sts[i].tb);
		}
		
	}
	
	
	public void maxToan() {
		System.out.println("---------------------");
		Enumeration Thao = list.elements();
		float max = 0;
		Students sinhVien = null;
		
		while(Thao.hasMoreElements())
		{
			Students sts = (Students)Thao.nextElement();
			if (sts.toan > max) {
				max =  sts.toan;
				sinhVien = sts;
			}
		}
		System.out.println("Ban " + sinhVien.hoten + " co diem toan cao nhat la :" + sinhVien.toan + "diem");
	}
	public void minToan() {
		System.out.println("----------------------");
		Enumeration Thao = list.elements();
		float min = 10;
		Students sinhVien = null;
		
		while(Thao.hasMoreElements())
		{
			Students sts = (Students)Thao.nextElement();
			if (sts.toan < min) {
				min =  sts.toan;
				sinhVien = sts;
			}
		}
		System.out.println("Ban " + sinhVien.hoten + " co diem toan thap nhat la :" + sinhVien.toan +"diem");
	}

	
	
	public void tuoi() {
		System.out.println("----------------");
		Enumeration Thao= list.elements();
		while (Thao.hasMoreElements())
		{
			Students sts= (Students)Thao.nextElement();
			if(sts.tuoi>23){
				System.out.println("Ban " + sts.hoten + " co tuoi lon hon 23 :" + sts.tuoi +"tuoi");
			}
		}
	}
	public void diachi() {
		System.out.println("---------------");
		Enumeration Thao= list.elements();
		while(Thao.hasMoreElements())
		{
			Students sts =(Students)Thao.nextElement();
			if(sts.diaChi.equals("Da Nang")) {
				System.out.println("Ban " + sts.hoten + " co dia chi o Da Nang " );
			}
		}
		
	}
	public void ten()
	{
		System.out.println("---------------");
		Enumeration Thao= list.elements();
		while(Thao.hasMoreElements())
		{
			Students sts= (Students)Thao.nextElement();
			if(sts.hoten.startsWith("Nguyen")) {
				System.out.println("Ban " + sts.hoten + " co ho Nguyen " );
			}
			
		}
	}
	
	
	
	public static void main(String[] args) {
		new BT9chapter2();
	}

}

class Students implements Comparable{
	String hoten;
	String diaChi;
	int tuoi;
	float toan;
	float li;
	float van;
	float tb;
	
	
	
	public Students(String ten, String diaChi,int tuoi,float toan, float li,float van) {
		this.hoten = ten;
		this.diaChi= diaChi;
		this.tuoi= tuoi;
		this.toan= toan;
		this.li= li;
		this.van= van;
		this.tb = (li + toan + van)/3;
	}
	
	
	public String getHoten() {
		return hoten;
	}


	public void setHoten(String hoten) {
		this.hoten = hoten;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public int getTuoi() {
		return tuoi;
	}


	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}


	public float getToan() {
		return toan;
	}


	public void setToan(float toan) {
		this.toan = toan;
	}


	public float getLi() {
		return li;
	}


	public void setLi(float li) {
		this.li = li;
	}


	public float getVan() {
		return van;
	}


	public void setVan(float van) {
		this.van = van;
	}


	public float getTb() {
		return tb;
	}


	public void setTb(float tb) {
		this.tb = tb;
	}


	@Override
	public int compareTo(Object o) {
		Students sts = (Students)o;
		return (int)(this.tb - sts.tb);
	}
}
