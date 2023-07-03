import WriteForm from "../components/body/board/WriteForm"

export default function ({setPosts, user}) {

  return (
    <>
      <WriteForm setPosts={setPosts} user={user}></WriteForm>
      <div style={{marginTop: "90px"}}>
      </div>
    </>

  )
}