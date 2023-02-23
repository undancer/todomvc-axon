import { useNavigate as useHistory } from 'react-router-dom'

export const withRouter = (Component: any) => {
  return (props: any) => {
    const history = useHistory()
    return <Component
            history={history}
            {...props}
        />
  }
}
