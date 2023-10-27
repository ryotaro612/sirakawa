import sys
import sqlalchemy.orm


def main():
    user = sys.argv[1]
    password = sys.argv[2]
    database = sys.argv[3]
    engine = sqlalchemy.create_engine(
        (
            f"mysql+pymysql://{user}:{password}"
            f"@127.0.0.1:3306/{database}?charset=utf8mb4"
        )
    )
    with sqlalchemy.orm.Session(engine) as session:
        stmt = sqlalchemy.text(
            ("SELECT company_company_id, description " "FROM disruptor")
        )
        result = session.execute(stmt, {})
        for row in result:
            print(row.company_company_id, row.description)
