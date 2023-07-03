import WriteForm from "../components/body/board/WriteForm"
import Header from "../components/header/Header"
import Footer from "../components/footer/Footer"

export default function ({setPosts,user}) {

  return (
    <>
      <WriteForm setPosts={setPosts} user = {user}></WriteForm>
      <div style={{marginTop : "90px"}}>
      </div>
    </>

  )
}