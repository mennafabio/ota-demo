#! /bin/bash

# define opentesting server
opentestingserver=http://localhost:50000
echo ${opentestingserver}

hpath=`pwd`
testname=`basename $@`

for testcase in $@
do
    echo "### ${testcase}:"

    if [ -d "${testcase}" ]; then
        cd ${testcase}

        for f in `ls .`
        do
          if [ ${f} != ${testname}.json ] && [ ${f} != ${testname}.yml ] && [ ${f} != test.json ] && [ ${f} != test.yml ]; then
            echo "FILE UPLOAD: " ${f}
            #using --data-binary to keep line endings during upload
            curl -X POST "${opentestingserver}/upload/file/${testname}/${f}" -H "accept: */*" -H "Content-Type: application/json" --data-binary @${f} && echo
          else
            echo "TEST UPLOAD: " ${f}
            cat ${f} |
            #Opentesting is running in host mode (local dev env), you might have to use Host IP when using VMs (for example Rancher Desktop on Linux, as Java app is running outside of the VM)
            sed -e "s/host.testcontainers.internal/localhost/g" |
            curl -X POST "${opentestingserver}/upload/test" -H "accept: */*" -H "Content-Type: application/json" --data-binary @- && echo
          fi
        done

        cd ${hpath}
    fi
done