package ETC.Union_Find;

public class Main {
    public static int[] parent = new int[1000001];

    public static int find(int x) {
        if (x == parent[x])//내가 부모라면
            return x;//내가 부모요
        else
            return parent[x] = find(parent[x]);//내가 부모가 아니면, 부모한테 부모 찾아달라하기(재귀로)
    }

    public static void union(int x, int y) {//둘이 묶기
        x = find(x);
        y = find(y);
        // 같은 부모를 가지고 있지 않을 때
        if (x != y) {
            // y가 x 보다 크다는 것을 가정한다면 아래와 같이 표현
            parent[y] = x;
            // 더 작은 값으로 넣어 줄 때 다음과 같이도 표현 가능
            /*
             * if(x < y) parent[y] = x; else parent[x] = y;
             */
        } else {
            System.out.println("fail");
        }
        //만약 같은 부모면 엮으면 순환이 일어남 네부모가 내부모고 그렇게 돌아서 묶을수 없음
    }
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 8; i++) {
            parent[i] = i;
        }
        union(1, 2);
        union(2, 3);
        System.out.println("1과 3은 연결되어 있나요? " + isSameParent(1, 3));
        union(2, 3);

    }


}
