import WriteForm from "../components/body/board/WriteForm"
import Header from "../components/header/Header"
import Footer from "../components/footer/Footer"

export default function ({setPosts}) {

  return (
    <>
      <WriteForm setPosts={setPosts}></WriteForm>
      <div style={{marginTop : "90px"}}>
      </div>
    </>

  )
}