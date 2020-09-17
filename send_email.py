import pymysql
import smtplib
import time
import re

DB_NAME = "FIRSTDB"
TABLE_NAME = "Products"
EMAIL_ADDR = "cesecese66@gmail.com"

def connect_db():
    """returns a connection to the database"""

    connect = False
    try: 
        connect = pymysql.connect(host = 'localhost', user = 'root', db = DB_NAME)
    except:  
        print("no connection")
    return connect


def get_rows(connect, key_header = False, key_wanted = False):
    """returns a tuple of database rows"""

    assert(hasattr(connect, "cursor"))

    query = "SELECT * FROM %s" % (TABLE_NAME)
    if key_header and key_wanted: 
        query += "WHERE %s = '%s'" % (key_header, key_wanted)

    cursor = connect.cursor()
    cursor.execute(query)

    if not cursor.rowcount: return False

    return cursor.fetchall()


def connect_email(): 
    """returns a connection to the smtp server"""

    server = smtplib.SMTP_SSL(host = "smtp.gmail.com", port = 465)
    for attempt in range(5):
        try:
            server.login(EMAIL_ADDR, input("please enter password: "))
            return server
        except:
            print("Bad Password")
    return False


def send_email(server, rows):
    """Sends emails from the server using tuple rows"""

    for row in rows:
        email = str(row[1])
        if not re.match("\w+@\w+\.\w+", email, re.ASCII): 
            continue
        try:
            server.sendmail(EMAIL_ADDR, email, "thank you")
        except:
            print("Email error")
            continue

        time.sleep(1)

    return


db = connect_db()
assert(db)

email_server = connect_email()
assert(email_server)

order_rows = get_rows(db)
if order_rows: send_email(email_server, order_rows)