package demo;

import java.util.List;

import com.mascloud.model.MoModel;
import com.mascloud.model.StatusReportModel;
import com.mascloud.sdkclient.Client;
import com.mascloud.util.JsonUtil;



public class Sdk2SmsSend {
	public static void main( String[] args ) {
		Client client = Client.getInstance( );
		// 登录地址需另外提供
		boolean isLoggedin = client.login( "http://112.35.4.197:15000", "stlpt9", "passwd@0987", "政企分公司测试" );
		if( isLoggedin ) {
			System.out.println( "Login successed" );
		} else {
			System.out.println( "Login failed" );
			return;
		}

		// 普通短信
		int rt = client.sendDSMS( new String[]{ "15210985914" }, "短信内容", "123", 1, "cwaH21lON", null, true );
		System.out.println( rt );

		// 模板短信
		int rtm = client.sendTSMS( new String[]{ "15210985911" }, "模板ID", new String[]{ "参数一", "参数二" }, "123", 0, "签名ID", null );
		System.out.println( rtm );

		// 获取状态报告——开始
		List<StatusReportModel> statusReportlist = client.getReport( );
		System.out.println( "getReport : " + JsonUtil.toJsonString( statusReportlist ) );
		// 获取状态报告——结束

		// 获取上行短信——开始
		List<MoModel> deliverList = client.getMO( );
		System.out.println( "getMO : " + JsonUtil.toJsonString( deliverList ) );
		// 获取上行短信——结束



	}
}
