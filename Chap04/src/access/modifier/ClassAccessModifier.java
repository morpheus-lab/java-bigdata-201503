package access.modifier;

public class ClassAccessModifier {
	
	class InnerClass {	// 객체가 가지고 있는 클래스 정보
		
	}
	
	public static void main(String[] args) {
		
//		ClassAccessModifier.PrivateInnerClass p
//		= new ClassAccessModifier.PrivateInnerClass();
		
		ClassAccessModifier m = new ClassAccessModifier();
		ClassAccessModifier.InnerClass p = m.new InnerClass();
		
	}
	
}

class DefaultModifierClass {
	
}

//private class PrivateModifierClass {	// 불가
//	
//}

//protected class ProtectedModifierClass {	// 불가
//	
//}
