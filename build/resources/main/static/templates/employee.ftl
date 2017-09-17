<HTML>
  <BODY>
    <FORM name="selfAppriasal" method="post">
        <#list model["userList"] as user>
          <label for="${model["userList"]?seq_index_of(user)}"><span style="display:block">${user}</span></label>
          <textarea id="${model["userList"]?seq_index_of(user)}"></textarea>
        </#list> 
    </FORM>
  </BODY>
</HTML>