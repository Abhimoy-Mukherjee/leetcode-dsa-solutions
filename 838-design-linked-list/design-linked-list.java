class MyLinkedList {
    int val;
    MyLinkedList next;
    MyLinkedList head;
    public MyLinkedList() {
        head=null;
    }
    public MyLinkedList(int val, MyLinkedList next){
        this.val=val;
        this.next=next;
    }
    
    public int get(int index) {
        int c=0;
        MyLinkedList temp=head;
        while(temp!=null){
            if(c==index)
                return temp.val;
            c++;
            temp=temp.next;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        MyLinkedList dummy = new MyLinkedList(val, null);
        dummy.next=head;
        head=dummy;
    }
    
    public void addAtTail(int val) {
        MyLinkedList end = new MyLinkedList(val, null);
        if(head==null){
            head=end;
            return;
        }
        MyLinkedList temp=head;
        while(temp.next!=null)
            temp=temp.next;
        temp.next=end;
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0)
            return;
        if(index==0){
            addAtHead(val);
            return;
        }
        int c=0;
        MyLinkedList temp=head;
        while(temp!=null && c<index-1){
            temp=temp.next;
            c++;
        }
        if(temp==null)
            return ;
        MyLinkedList dummy = new MyLinkedList(val, temp.next);
        temp.next = dummy;
    }
    
    public void deleteAtIndex(int index) {
        if(head==null || index<0)
            return ;
            if(index==0){
                head=head.next;
                return;
            }
            int c=0;
            MyLinkedList temp=head;
            MyLinkedList prev=null;
            while(temp!=null)
            {
                if(c==index){
                    prev.next=temp.next;
                    temp.next=null;
                    return;
                }
                prev=temp;
                temp=temp.next;
                c++;
            }
        }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */