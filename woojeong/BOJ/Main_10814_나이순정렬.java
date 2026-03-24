import java.util.*;

class User implements Comparable<User> {
	int age;
	String name;
	
	User(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(User o) {
		if(this.age == o.age) return 0; //먼저 가입한 사람이 앞에(순서유지)
		else return this.age - o.age;	
	};
}

public class Main_10814_나이순정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //회원 수 
		
		User[] user = new User[N];
		for(int i = 0; i < N; i++) {
			int age = sc.nextInt();
			String name = sc.next();
			user[i] = new User(age, name);
		}
		
		Arrays.sort(user);

		for(int i = 0; i < N; i++) {
			System.out.println(user[i].age + " " + user[i].name);
		}
	}
}

//익명클래스
//list.sort((m1, m2) -> {
//    if (m1.age != m2.age) {
//        return Integer.compare(m1.age, m2.age);
//    }
//    return Integer.compare(m1.join, m2.join);
//});
