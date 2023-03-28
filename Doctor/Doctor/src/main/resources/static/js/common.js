var CommonJS={
	
	   GetQueryStringValue: function(key) {
        var temp = location.search.match(new RegExp(key + "=(.*?)($|\&)", "i"));
        if (!temp)
            return "";
        return temp[1];
    }
}

