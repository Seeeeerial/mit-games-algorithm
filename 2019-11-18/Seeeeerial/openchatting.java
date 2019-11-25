import java.util.LinkedList;

public class solution {
	public String[] solving(String[] record) {
        String[] answer = {};
        int count = 0;		//������ �����ٴ� ���� ��� ���Դ��� Ȯ�ο�
        
        
        LinkedList<User> userList = new LinkedList<User>();
        
        count = inputData(record,userList,count);
        
        answer = new String[count]; 
        
        answer = printMessage(answer,record,userList);
        
        return answer;
    }
	
	private int inputData(String[] record, LinkedList<User> userList, int count)
	{
		boolean isAdded = false;
        for(int i = 0 ; i < record.length ; i++)
        {
        	String[] split = record[i].split(" ");
        	
        	if(split[0].equals("Change"))		//�г����� �ٲ��� ��
        	{
        		for(int j = 0; j < userList.size(); j++) //���� ���̵��� ���� ã�Ƽ� �̸��ٲ��ֱ�
        		{
        			if(userList.get(j).id.equals(split[1]))
        			{
        				userList.get(j).name = split[2];
        			}
        		}
        	}
        	else if(split[0].equals("Enter"))		//������ ��
        	{
        		count++;
        		for(int j = 0; j < userList.size(); j++)	//������ �ִ� ������ �̸��� �ٲ���
        		{
        			if(userList.get(j).id.equals(split[1]))
        			{
        				userList.get(j).name = split[2];
        				isAdded = true;
        				break;
        			}
        		}
        		if(!(isAdded))			//������ ������ ���� ����Ʈ�� �߰�
        			userList.add(new User(split[1],split[2]));
        		isAdded = false;
        	}
        	else if(split[0].equals("Leave"))
        		count++;
        }
        return count;
	}
	
	//������ ����� �޼����� �ִ� �Լ�
	private String[] printMessage(String[] answer, String[] record, LinkedList<User> userList)
	{
        for(int i = 0 ; i < record.length ; i++)		//���
        {
        	String[] split = record[i].split(" ");
        	
        	if(split[0].equals("Enter"))		//����
        	{
        		for(int j = 0; j < userList.size(); j++)	//������ �ִ� ������ �̸��� �ٲ���
        		{
        			if(userList.get(j).id.equals(split[1]))
        			{
        				answer[i] = userList.get(j).name + "���� ���Խ��ϴ�.";
        				break;
        			}
        		}
        	}
        	else if(split[0].equals("Leave"))		//����
        	{
        		for(int j = 0; j < userList.size(); j++)	//������ �ִ� ������ �̸��� �ٲ���
        		{
        			if(userList.get(j).id.equals(split[1]))
        			{
        				answer[i] = userList.get(j).name + "���� �������ϴ�.";
        				break;
        			}
        		}
        	}
        }
        
        return answer;
	}
}

class User
{
    public String id;
    public String name;
    
    public User(String id, String name)
    {
    	this.id = id;
    	this.name = name;
    }
}