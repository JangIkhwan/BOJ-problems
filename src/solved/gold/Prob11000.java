package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prob11000 {
    /*
    https://www.acmicpc.net/problem/11000

    25/8/19 10:58 ~ 12:14

    최소의 강의실을 사용하여서 스케줄링해야 함

    현재 할당된 모든 강의실에 겹치는 일정이 있으면 새로운 강의실을 잡아야함

5
1 3
2 4
3 5
4 6
5 7

    시간 복잡도는 N log N 이하여야 함
    뭔가 그리디스러운 방법을 써야할 것 같은 느낌?

    가설
    모든 일정을 시작 시간에 따라 정렬
    정렬된 일정을 차례로 앞 일정과 가장 시간 차이가 적은 강의실에 배정
    모든 강의실에 배정할 수 없으면 다른 강의실에 배정

    그냥 배열이면 시간 초과가 발생함
    뭔가 빠르게 정렬을 수행해서 내가 원하는 값을 내놓는 자료구조이면 좋겠는데
    우선순위 큐?

    힌트를 참고하니 종료 시간이 가장 빠른 것에 배정하면 됨
    왜냐하면 일정은 시작시간 순으로 미리 정렬되어 있기 때문임
     */

    public static void fail1(String[] args) throws IOException{
        final int INF = 1123456789;
        int N;
        Course[] courses;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        N = Integer.parseInt(br.readLine());
        courses = new Course[N];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            courses[i] = new Course(s, e);
        }

        // 강의를 시작 시간에 대해 정렬
        Arrays.sort(courses, (a, b) -> a.start - b.start);

        // 강의를 가설에 맞게 강의실에 할당
        int numOfRoom = 0;
        Course[] room = new Course[N];

        for(Course course : courses){
            int selected = -1;
            int minDiff = INF;
            for(int i = 0; i < numOfRoom; i++){
                if(room[i].end <= course.start){
                    int diff = room[i].end - course.start;
                    if(diff < minDiff){
                        minDiff = diff;
                        selected = i;
                    }
                }
            }
            if(selected != -1){
                room[selected] = course;
                continue;
            }
            room[numOfRoom] = course;
            numOfRoom++;
        }

        // 할당된 강의실을 출력
        System.out.println(pq.size());
    }
    public static void fail2(String[] args) throws IOException{
        int N;
        Course[] courses;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        N = Integer.parseInt(br.readLine());
        courses = new Course[N];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            courses[i] = new Course(s, e);
        }

        // 강의를 시작 시간에 대해 정렬
        Arrays.sort(courses, (a, b) -> a.start - b.start);

        // 강의를 가설에 맞게 강의실에 할당
        PriorityQueue<Course> pq = new PriorityQueue<>((a, b) -> b.start - a.start);
        PriorityQueue<Course> buffer = new PriorityQueue<>((a, b) -> b.start - a.start);
        PriorityQueue<Course> temp = new PriorityQueue<>((a, b) -> b.start - a.start);
        for(Course course : courses){
            boolean replaced = false;
            while(!pq.isEmpty()){
                Course poll = pq.poll();
                if(poll.end <= course.start){
                    pq.offer(course);
                    replaced = true;
                    while(!buffer.isEmpty()){
                        pq.offer(buffer.poll());
                    }
                    break;
                }
                buffer.offer(poll);
            }
            if(replaced){
                continue;
            }
            temp = pq;
            pq = buffer;
            buffer = temp;
            buffer.clear();
            pq.offer(course);
        }

//        int numOfRoom = 0;
//        Course[] room = new Course[N];
//
//        for(Course course : courses){
//            int selected = -1;
//            int minDiff = INF;
//            for(int i = 0; i < numOfRoom; i++){
//                if(room[i].end <= course.start){
//                    int diff = room[i].end - course.start;
//                    if(diff < minDiff){
//                        minDiff = diff;
//                        selected = i;
//                    }
//                }
//            }
//            if(selected != -1){
//                room[selected] = course;
//                continue;
//            }
//            room[numOfRoom] = course;
//            numOfRoom++;
//        }

        // 할당된 강의실을 출력
        System.out.println(pq.size());
    }


    public static void main(String[] args) throws IOException{
        int N;
        Course[] courses;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        N = Integer.parseInt(br.readLine());
        courses = new Course[N];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            courses[i] = new Course(s, e);
        }

        // 강의를 시작 시간에 대해 정렬
        Arrays.sort(courses, (a, b) -> a.start - b.start);

        // 강의를 가설에 맞게 강의실에 할당
        PriorityQueue<Course> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
        for(Course course : courses){
            if(pq.isEmpty()){
                pq.offer(course);
                continue;
            }
            Course poll = pq.poll();
            if(poll.end <= course.start){
                pq.offer(course);
            }
            else{
                pq.offer(poll);
                pq.offer(course);
            }
        }

        // 할당된 강의실을 출력
        System.out.println(pq.size());
    }

    static class Course{
        int start;
        int end;

        public Course(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
