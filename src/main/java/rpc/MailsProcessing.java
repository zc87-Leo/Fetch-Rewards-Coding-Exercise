package rpc;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class MailsProcessing
 */
public class MailsProcessing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MailsProcessing() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject input = RpcHelper.readJSONObject(request);
		JSONArray mailsList = input.getJSONArray("emails_list");
		Set<String> set = new HashSet<>(); //in order to remove duplicate 
		JSONObject obj = new JSONObject();
		for (Object j : mailsList) {
			String s = j.toString();
			s = s.substring(0, s.length() - 10); // must be gmail (remove "@gmail.com")
			char[] array = s.toCharArray();
			StringBuilder sb = new StringBuilder();
			for (char c : array) { //Logic: 1. Ignore'.'；  2.Ignore the part after "+"；
				if (c == '.') {
					continue;
				} else if (c == '+') {
					break;
				} else {
					sb.append(c);
				}
			}
			set.add(sb.toString());
		}
		obj.put("number_of_unique_emails", set.size());
		RpcHelper.writeJsonObject(response, obj);
	}
}
