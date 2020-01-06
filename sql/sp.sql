CREATE OR REPLACE FUNCTION show_students(in s_age integer) RETURNS refcursor AS $$   
declare ref refcursor;
BEGIN
	OPEN ref FOR SELECT name, age FROM student where age > s_age; 
    RETURN ref;                    
END;
$$ LANGUAGE plpgsql;